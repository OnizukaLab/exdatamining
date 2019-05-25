package udaf

import org.apache.spark.SparkContext
import scala.math.log
import java.io.{FileOutputStream, OutputStreamWriter}


object Evaluate {
  /*------------------------------
    出力関連のファイル設定
    -> ファイルパス : results/{data}/{app}{_{method}}.csv
    Port and Commodity Data
    ------------------------------*/
  var data_name: String = ""
  var output_file: String = ""
  var file_share: String = ""
  var file_pruning: String = ""
  var file_baseline: String = ""
  var lof_ans_filename: String = ""
  var gof_ams_filename: String = ""

  private def init_foreval_params(data: Int, method: String, datasize: Int): Unit = {
    data_name = "Flights2"
    output_file = "results/%s/deim2019.csv" format data_name
    file_share = "results/%s/deim2019_share.csv" format data_name
    file_pruning = "results/%s/deim2019_pruning.csv" format data_name
    file_baseline = "results/%s/deim2019_baseline.csv" format data_name
    lof_ans_filename = "results/%s/lof_answer.csv" format data_name
    gof_ams_filename = "results/%s/gof_answer.csv" format data_name
  }

  /*--------------------------------
    Function: Output results
    --------------------------------*/
  def output_results(app: Int, data: Int, method: String, sc: SparkContext, datasize: Int, k: Int, z_p: Double, pertition: Int, todf_time: Double, udaf_time: Int, map_merge_time: Int, compute_time: Int, all_time: Int, subsetkey: List[String], pruning_rates: List[Double]): Unit = {
    init_foreval_params(data, method, datasize)

    val ndcg: Double = method match {
      case "SharePruning" | "Pruning" => Calc_ndcg(app, sc, k, subsetkey)
      case _ => 1.0
    }

    val precision: Double = method match {
      case "SharePruning" | "Pruning" => Calc_precision(app, sc, k, subsetkey)
      case _ => 1.0
    }

    val filename: String = method match {
      case "SharePruning" => output_file
      case "Share" => file_share
      case "Pruning" => file_pruning
      case "Baseline" => file_baseline
      case _ => ""
    }

    // 書き込み処理準備
    val fileOutputStream = new FileOutputStream(filename, true)
    val writer = new OutputStreamWriter(fileOutputStream, "utf-8")

    writer.write("\n")

    // 実験時間・NDCG・Precision 書き込み
    // 枝刈り率の書き込み
    method match {
      case "SharePruning" | "Pruning" =>
        writer.write("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
          format(app, datasize, k, z_p, pertition, todf_time.toDouble / 1000, udaf_time.toDouble / 1000, map_merge_time.toDouble / 1000, compute_time.toDouble / 1000, all_time.toDouble / 1000, ndcg, precision))
        pruning_rates.foreach(rate => writer.write(",%s" format rate))
      case _ =>
        writer.write("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
          format(app, datasize, k, z_p, todf_time.toDouble / 1000, udaf_time.toDouble / 1000, map_merge_time.toDouble / 1000, compute_time.toDouble / 1000, all_time.toDouble / 1000, ndcg, precision))
    }

    // 分析結果の書き込み
    subsetkey.foreach { subset =>
      val subset_key = subset.replaceAll(" ", "")
      if (subset_key != "All") {
        writer.write(",%s" format subset_key.replaceAll(" ", ""))
      }
    }
    writer.close
  }

  /*--------------------------------
    Function: Calculate nDCG
   --------------------------------*/
  private def Calc_ndcg(app: Int, sc: SparkContext, k: Int, subsetkey: List[String]): Double = {
    /*
      read currect answer
     */
    val ans_filename = app match {
      case 1 => gof_ams_filename
      case 2 => lof_ans_filename
      case _ => ???
    }
    val answer = sc.textFile(ans_filename).filter(line => !line.contains("ranking")).map {
      row =>
        val elm = row.split(",")
        (elm(0).toInt, elm(1), elm(2).toDouble)
    }.toLocalIterator.toList

    /*
      make map ( subset key -> value )
     */
    var ranking_map = scala.collection.mutable.Map[String, Double]()
    ranking_map ++= answer.map { rank => rank._2 -> rank._3 }

    /*
      calc dcg
     */
    var dcg: Double = 0.0
    var ii = 0
    subsetkey.filter(key => key != "All").foreach { key =>
      ii += 1
      println(key)
      ii match {
        case 1 => dcg += ranking_map(key.replaceAll(" ", ""))
        case _ => dcg += ranking_map(key.replaceAll(" ", "")) * log(2.0) / log(ii)
      }
    }

    /*
      calc dcg_i
     */
    var dcg_i: Double = 0.0
    ii = 0
    answer.filter(ff => ff._1 <= k).foreach { rank =>
      ii += 1
      ii match {
        case 1 => dcg_i += rank._3
        case _ => dcg_i += rank._3 * log(2.0) / log(ii)
      }
    }

    dcg / dcg_i
  }

  /*--------------------------------
    Function: Calculate nDCG
    --------------------------------*/
  private def Calc_precision(app: Int, sc: SparkContext, k: Int, subsetkey: List[Any]): Double = {
    val ans_filename = app match {
      case 1 => gof_ams_filename
      case 2 => lof_ans_filename
      case _ => ???
    }
    val answer = sc.textFile(ans_filename).filter(line => !line.contains("ranking")).map {
      row =>
        val elm = row.split(",")
        if (elm(0).toInt <= k) {
          elm(1)
        }
    }.toLocalIterator.toList.filterNot(_ == ())
    val subset_list = subsetkey.filter(key => key != "All").map { key => key.toString.replace(" ", "") }

    1.0 - (answer diff subset_list).size / k.toDouble
  }


  /*-------------------------------------------
    Function: correct result write
   -------------------------------------------*/
  def currect_results(app: Int, results: List[(String, (Double, Double))]): Unit = {
    init_foreval_params(1, "Share", 1)
    /*
      書き込み処理準備
     */
    val ans_filename = app match {
      case 1 => gof_ams_filename
      case 2 => lof_ans_filename
      case _ => ???
    }
    println("ans_filename = %s" format ans_filename)
    val fileOutputStream = new FileOutputStream(ans_filename, true)
    val writer = new OutputStreamWriter(fileOutputStream, "utf-8")
    /*
      正解結果の書き込み
     */
    var ranking = 1
    results.foreach { f =>
      writer.write("%s,%s,%s\n" format(ranking, f._1.replaceAll(" ", ""), f._2._1))
      ranking += 1
    }
    writer.close
  }
}
