package udafApp

import org.apache.spark.sql.DataFrame

import scala.math.{abs, _}

object Application {
  // Search Global outlier Application
  // Input  : Cube(All, Subsetdata)
  // Output : Subsetdata,
  def global_outlier(k: Int, all: Map[String, Seq[Double]], subset: Map[String, Map[String, Seq[Double]]]): List[List[(String, (Double, Double))]] = {
    // 部分データ毎の処理
    val subset_deviance = subset.map { case (key, mmap) =>
      // 乖離度の計算
      var deviance: (Double, Double) = (0D, 0D) //(Max, Min)

      all.foreach { case (x_value, y_seq) =>
        val subset_value = mmap.getOrElse(x_value, Seq(0.0, 0.0))
        val dis_pattern = List(abs(y_seq.head - subset_value.head), abs(y_seq.head - subset_value(1)), abs(y_seq(1) - subset_value.head), abs(y_seq(1) - subset_value(1)))
        deviance = (deviance._1 + dis_pattern.max, deviance._2 + dis_pattern.min)
      }

      key -> deviance
    }.toList.sortBy(_._2).reverse

    // 閾値の保持
    val under_threshold: Double = subset_deviance(min(subset_deviance.size, k) - 1)._2._2
    // 探索を行う部分データの取得
    // subset_deviance.foreach(println)
    // val a: List[(String,(Double,Double))] = subset_deviance
    return List(
      subset_deviance.filter(f => f._2._1 >= under_threshold),
      subset_deviance.filter(f => f._2._1 < under_threshold)
    ) //.map { f => f._1 }
  }

  /* GOF for dataframe ----------
    1. 全体平均の計算
    2. 部分データ毎の乖離度を計算
    3. 閾値の計算
    4. 足切りの部分データのkey情報のList化
    5. 返り値の設定
    ------------------------------*/
  def gof(k: Int, agg_func: String, z_p: Double, all_df: DataFrame, df: DataFrame): List[String] = {
    // step.1
    val Seq(all_count, all_avg, all_sum, all_var) = all_df.head.toSeq
    val all_interval: (Double, Double) = agg_func match {
      case "AVG" =>
        (all_avg.toString.toDouble + math.sqrt(z_p * all_var.toString.toDouble / all_count.toString.toDouble),
          all_avg.toString.toDouble - math.sqrt(z_p * all_var.toString.toDouble / all_count.toString.toDouble))
      case "SUM" =>
        (all_sum.toString.toDouble + math.sqrt(z_p * all_var.toString.toDouble * all_count.toString.toDouble),
          all_sum.toString.toDouble - math.sqrt(z_p * all_var.toString.toDouble * all_count.toString.toDouble))
    }
    // step. 2
    // step. 3
    val under_threshold: Double = ???
    // step. 4

    // step. 5
    return List[String]()
  }

  /* LOF for dataframe ----------
  1. 全体平均の計算
  2. 部分データ毎の乖離度を計算
  3. 閾値の計算
  4. 足切りの部分データのkey情報のList化
  5. 返り値の設定
  ------------------------------*/
  def lof() = {

  }
}
