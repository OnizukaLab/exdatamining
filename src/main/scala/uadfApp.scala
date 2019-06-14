package udafApp

import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object udafApp {
  /*------------------------------
    SparkContext インスタンスの生成
   ------------------------------*/
  val conf = new SparkConf().setAppName("Test").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  import sqlContext.implicits._

  /*------------------------------
    パラメータの設定・初期化
   ------------------------------*/
  var block_num: Int = 0
  var result_gof: List[(String, (Double, Double))] = List.empty[(String, (Double, Double))]
  var result_lof: List[(String, (Double, Double))] = List.empty[(String, (Double, Double))]
  var subset_key: List[String] = List.empty[String]
  var pruning_subset_key: List[String] = List.empty[String]
  val part_cube = scala.collection.mutable.HashMap.empty[String, Map[String, Seq[Double]]]
  var saa: List[List[String]] = List.empty[List[String]]
  var pruning_rates: List[Double] = List.empty[Double]
  var pruning_num: List[Int] = List.empty[Int]

  /*-----------------------------------------
    実験で使用するパラメータの設定
      * sub_num : 部分データの総数
      * z_p     : 95％信頼区間のZ_p
      * k       : 探索する上位の件数 (Top-k)
      * per     : データ分割数
      * rates   : データ分割の粒度(分割率)
   -----------------------------------------*/
  val sub_num: Int = 316
  val z_p: Double = 1.96 * 1.96
  var k: Int = 10
  var datasize: Int = 1
  var decrease_size: Int = 100
  var pertition: Int = 2
  val rates: Array[Double] = Array.fill(pertition)(1.0 / pertition)

  /*------------------------------
    時間計測用のパラメータの初期化
   ------------------------------*/
  var udaf_time: Int = 0
  var map_merge_time: Int = 0
  var todf_time: Int = 0
  var compute_time: Int = 0
  var rap_time: List[Any] = List[Any]()
  var all_time: Int = 0
  var start: Int = System.currentTimeMillis().toInt
  val k_list: List[Int] = List[Int](1, 5, 10, 15, 20, 25, 30)
  val size_list: List[Int] = List[Int](2, 4, 6, 8, 10)

  /*------------------------------
    パラメータ初期化用関数
   ------------------------------*/
  private def initparameter(): Unit = {
    block_num = 0
    result_gof = List.empty[(String, (Double, Double))]
    result_lof = List.empty[(String, (Double, Double))]
    subset_key = List.empty[String]
    pruning_subset_key = List.empty[String]
    part_cube.clear()
    saa = List.empty[List[String]]
    pruning_rates = List.empty[Double]
    pruning_num = List.empty[Int]
    pertition *= datasize

    udaf_time = 0
    map_merge_time = 0
    todf_time = 0
    compute_time = 0
    rap_time = List[Any]()
    all_time = 0
    start = System.currentTimeMillis().toInt
  }

  def main(args: Array[String]) {
    /*---------------------------------------------------------------------------------
    <手法>
      method 変数で制御
      1. 提案手法　　　　　:　SharePruning()
      2. クエリ共有化のみ　:　Share()
      3. 枝刈りのみ　　　　:　Pruning()
      4. ベースライン　　　:　BaseLine()

    <Application>
      app 変数で制御
      * app = 1 : Global Outlier Factor
      * app = 2 : LOF(Local Outlier Factor
      * app = 3 : seedb
      * app = 4 : 回帰分析 (Regression Anaysis)

    <データ種類>
      data 変数で制御
      * data = 1 : Flight Delay Data
      * data = 2 : Port and Commodity Data
      * data = 3 : Border Crossing Data
    --------------------------------------------------------------------------------- */
    /*-------------
      実験条件の設定
    --------------*/
    val app: Int = 2
    val data: Int = 1
    val method: String = ("Baseline", "Share", "SharePruning")._1
    val output_ver: String = ("Experiment", "Correct")._1

    val DF_block: Array[DataFrame] = ReadData.read_split_data(sqlContext, data_flg = data, partition = pertition)
    val ALL_DF: DataFrame = ReadData.read_all_data(sqlContext)

    ALL_DF.cache()
    DF_block.foreach(b => b.cache())

    for (roop_iterator <- k_list) { // データサイズ(size_list) or 探索件数のパラメータ変更(k_list)
      k = roop_iterator
      for (_ <- 1 to 3) { // 同じパラメータでの繰り返し回数
        // 実験用パラメータの初期化
        initparameter()

        /*-------------
          手法選択
        --------------*/
        method match {
          case "SharePruning" => SharePruning(app, DF_block)
          case "Share" => Share(app, ALL_DF)
          case "Pruning" => Pruning(app, ALL_DF, DF_block)
          case "Baseline" => BaseLine(app, ALL_DF)
          case _ => println("- Missing Select Method -")
        }

        res_output(app, data, method, output_ver) // 結果の出力

        val wait_start = System.currentTimeMillis().toInt
        while (System.currentTimeMillis().toInt - wait_start < 30000) {}
      }
    }

    sc.stop //Warning 対策
  }

  private def res_output(app: Int, data: Int, method: String, output_ver: String): Unit = {
    println(output_ver)
    output_ver match {
      case "Experiment" =>
        for (app <- 1 to 2) {
          subset_key = app match {
            case 1 => result_gof.map(_._1) :+ "All"
            case 2 => result_lof.map(_._1) :+ "All"
            case _ => ???
          }
          Evaluate.output_results(
            app, data, method, sc,
            datasize, k, z_p, pertition,
            todf_time, udaf_time, map_merge_time, compute_time, all_time,
            subset_key, pruning_rates
          )
        }
        println(todf_time, udaf_time, map_merge_time, compute_time)
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
        println("all_time : %s" format all_time)
        println("pruning_rates : %s" format pruning_rates)
        println("pruning_num : %s" format pruning_num)
        println("rap_time : %s" format rap_time)
        println("--------------")
        println("gof_res: %s" format result_gof.map(_._1))
        println("lof_res: %s" format result_lof.map(_._1))
        println("pruning_subset: %s" format pruning_subset_key)
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")

      case "Correct" =>
        Evaluate.currect_results(app, result_gof) //TODO : GOFとLOF両方の正解データの出力に対応していない

      case _ => ???
    }
  }

  /* ---------------------------------------------------------------------------------
    Set Query's Parameter
   --------------------------------------------------------------------------------- */
  val s: String = "OriginCityName"
  val x: String = "Quarter"
  val y: String = "DepDelay"
  val agg_func: String = "AVG"

  private def execute_udaf(table: String): DataFrame = {
    sqlContext.sql(
      "SELECT Engine(%s, %s, %s) from %s" format(s, x, y, table)
    )
  }

  private def execute_udaf_subset(table: String, sub_key: String): DataFrame = {
    sqlContext.sql(
      "SELECT Engine(%s, %s, %s) from %s where %s = \"%s\"" format(s, x, y, s, table, sub_key)
    )
  }

  private def execute_all(table: String): DataFrame = {
    sqlContext.sql(
      "SELECT %s, count(*), sum(%s)/count(*), variance(%s) FROM %s GROUP BY %s" format(x, y, y, table, x)
    )
  }

  private def execute_subset_query(table: String, where: String): DataFrame = {
    sqlContext.sql(
      "SELECT %s, count(*), sum(%s)/count(*), variance(%s) FROM %s WHERE %s = \"%s\" GROUP BY %s" format(x, y, y, table, s, where, x)
    )
  }

  private def get_subset(table: String, where: String): Array[String] = {
    sqlContext.sql(
      "SELECT %s FROM %s GROUP BY %s" format(where, table, where)
    ).collect.map {
      _ (0).toString
    }
  }

  /* ---------------------------------------------------------------------------------
    提案手法（クエリ共有化 & 枝刈り）
   --------------------------------------------------------------------------------- */
  def SharePruning(app: Int, EntireDF: Array[DataFrame]) {
    sqlContext.udf.register("Engine", new ExperimentEngine)

    // ブロックに毎に実行
    EntireDF.foreach { block =>
      val block_df = block.toDF()
      block_df.cache()
      // step. Pruning
      val start_todf: Int = System.currentTimeMillis().toInt
      if (subset_key.isEmpty) {
        block_df.createOrReplaceTempView("SharePruning")
      }
      else {
        block_df.filter(!$"OriginCityName".isin(pruning_subset_key: _*)).createOrReplaceTempView("SharePruning")
      }
      todf_time += System.currentTimeMillis().toInt - start_todf

      if (pruning_subset_key.length != sub_num - k) {
        // step. データブロックをのデータキューブ化
        val start_udaf = System.currentTimeMillis().toInt
        val mp = execute_udaf("SharePruning").first().getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換
        udaf_time += System.currentTimeMillis().toInt - start_udaf.toInt

        // step. DataCubeのマージ
        val start_map_merge: Int = System.currentTimeMillis().toInt
        part_cube ++= mp.map { case (k1, mmp) =>
          val m1 = part_cube.getOrElse(k1, Map())
          val merged = m1 ++ mmp.map { case (x_value, v_list) =>
            val ss = m1.getOrElse(x_value, Seq(0D, 0D, 0D))
            val count = ss.head + v_list.head
            val average = (ss.head * ss(1) + v_list.head * v_list(1)) / count.toDouble
            val variance = (ss.head * (ss(2) + ss(1) * ss(1)) + v_list.head * (v_list(2) + v_list(1) * v_list(1))) / count - average * average
            x_value -> Seq(count, average, variance)
          }
          k1 -> merged
        }
        map_merge_time += System.currentTimeMillis().toInt - start_map_merge
      }

      // step. DataCubeの再構築 & 信頼区間の算出
      val start_compute: Int = System.currentTimeMillis().toInt
      val interval = part_cube.map { case (subset, value_cube) =>
        subset ->
          value_cube.map { case (k1, v) =>
            if (block_num != pertition - 1) {
              // 集約関数: AVG
              agg_func match {
                case "AVG" =>
                  val interval_avg = Math.sqrt(z_p * v(2) / v.head)
                  k1 -> Seq(v(1) + interval_avg, v(1) - interval_avg)
                case "SUM" =>
                  val interval_sum = Math.sqrt(Math.sqrt(z_p * v(2) * v.head))
                  k1 -> Seq(v(1) + interval_sum, v(1) - interval_sum)
              }
            }
            else {
              agg_func match {
                case "AVG" => k1 -> Seq(v(1), v(1))
                case "SUM" => k1 -> Seq(v(1), v(1))
              }
            }
          }
      }
      var res_gof = List[List[(String, (Double, Double))]]()
      var res_lof = List[List[(String, (Double, Double))]]()
      val future_gof = Future {
        res_gof = Application.global_outlier(k, interval.get("All").toSeq.head, interval.-("All").toMap)
      }
      val future_lof = Future {
        res_lof = LOF.naive_executer(k, interval.-("All").toMap)
      }
      val ff = future_gof.zip(future_lof)
      while (!ff.isCompleted) {}
      result_gof = res_gof.head
      result_lof = res_lof.head

      pruning_subset_key = (pruning_subset_key ::: res_gof(1).map(f => f._1).intersect(res_lof(1).map(f => f._1))).distinct
      pruning_rates = pruning_rates :+ pruning_subset_key.length * 100 / sub_num.toDouble
      pruning_num = pruning_num :+ pruning_subset_key.length

      compute_time += System.currentTimeMillis().toInt - start_compute
      rap_time = rap_time :+ (System.currentTimeMillis.toInt - start)
      block_num += 1
    }
    all_time = System.currentTimeMillis().toInt - start
  }

  /* ---------------------------------------------------------------------------------
    クエリ共有化のみ行う手法
   --------------------------------------------------------------------------------- */
  def Share(app: Int, EntireDF: DataFrame): Unit = {
    sqlContext.udf.register("Engine", new ExperimentEngine)
    EntireDF.createOrReplaceTempView("Share")

    // step. Make Data Cube
    val start_udaf = System.currentTimeMillis().toInt
    part_cube ++= execute_udaf("Share").first().getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換
    udaf_time += System.currentTimeMillis().toInt - start_udaf.toInt

    // Cubeの再構築 & 信頼区間の算出
    val start_compute: Int = System.currentTimeMillis().toInt
    val interval = part_cube.map { case (subset, value_cube) =>
      subset ->
        value_cube.map { case (k1, v) =>
          agg_func match {
            case "AVG" => k1 -> Seq(v(1), v(1))
            case "SUM" => k1 -> Seq(v(1), v(1))
          }
        }
    }
    result_gof = Application.global_outlier(k, interval.get("All").toSeq.head, interval.-("All").toMap).head
    result_lof = LOF.naive_executer(k, interval.-("All").toMap).head
    compute_time += System.currentTimeMillis().toInt - start_compute

    all_time = System.currentTimeMillis().toInt - start
  }

  /* --------------------------------------------------------------------------------------------------------------------
    枝刈りのみ行う手法
   -------------------------------------------------------------------------------------------------------------------- */
  def Pruning(app: Int, ALLDF: DataFrame, EntireDF: Array[DataFrame]): Unit = {
    sqlContext.udf.register("Engine", new ExperimentEngine)

    // step. 全体データの作成(事前計算)
    ALLDF.createOrReplaceTempView("ALL")

    val AllMap: Map[String, Seq[Double]] =
      execute_all("ALL").collect.map { r =>
        r.toSeq.head.toString -> Seq(r.toSeq(2).toString.toDouble, r.toSeq(2).toString.toDouble)
      }.toMap

    // step. クエリの作成
    val subset_array: Array[String] = get_subset("ALL", "OriginCityName")

    // step. シーケンシャルにクエリをデータをブロックに分割し, ブロック毎にApplication Layerを実行し, 枝仮判定
    EntireDF.foreach { block =>
      subset_array.foreach { s_key =>
        if (!pruning_subset_key.contains(s_key) & pruning_subset_key.length != sub_num - k) {
          val start_todf: Int = System.currentTimeMillis().toInt
          block.filter($"OriginCityName" === s_key).createOrReplaceTempView("Pruning")
          todf_time += System.currentTimeMillis().toInt - start_todf

          val start_udaf = System.currentTimeMillis().toInt
          val mp = execute_udaf("Pruning").first().getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換
          udaf_time += System.currentTimeMillis().toInt - start_udaf.toInt

          // step. DataCubeのマージ
          val start_map_merge: Int = System.currentTimeMillis().toInt
          part_cube ++= mp.map { case (k1, mmp) =>
            val m1 = part_cube.getOrElse(k1, Map())
            val merged = m1 ++ mmp.map { case (x_value, v_list) =>
              val ss = m1.getOrElse(x_value, Seq(0D, 0D, 0D))
              val count = ss.head + v_list.head
              val average = (ss.head * ss(1) + v_list.head * v_list(1)) / count.toDouble
              val variance = (ss.head * (ss(2) + ss(1) * ss(1)) + v_list.head * (v_list(2) + v_list(1) * v_list(1))) / count - average * average
              x_value -> Seq(count, average, variance)
            }
            k1 -> merged
          }

          map_merge_time += System.currentTimeMillis().toInt - start_map_merge
          // step. DataCubeの再構築 & 信頼区間の算出
          val start_compute: Int = System.currentTimeMillis().toInt
          val interval = part_cube.map { case (subset, value_cube) =>
            subset ->
              value_cube.map { case (k1, v) =>
                if (block_num != pertition - 1) {
                  agg_func match {
                    case "AVG" =>
                      val interval_avg = Math.sqrt(z_p * v(2) / v.head)
                      k1 -> Seq(v(1) + interval_avg, v(1) - interval_avg)
                    case "SUM" =>
                      val interval_sum = Math.sqrt(Math.sqrt(z_p * v(2) * v.head))
                      k1 -> Seq(v(1) + interval_sum, v(1) - interval_sum)
                  }
                }
                else {
                  agg_func match {
                    case "AVG" => k1 -> Seq(v(1), v(1))
                    case "SUM" => k1 -> Seq(v(1), v(1))
                  }
                }
              }
          }

          if (app == 1) {
            val result12 = Application.global_outlier(k, AllMap, interval.-("All").toMap)
            result_gof = result12.head
            subset_key = result_gof.map(f => f._1) :+ "All"
            pruning_subset_key = pruning_subset_key ::: result12(1).map(f => f._1)

            saa = saa :+ subset_key
            part_cube.retain((k, _) => subset_key.contains(k))
          }
          else if (app == 2) {
            print("SeeDB")
          }
          else {
            print("LoF")
          }
          compute_time += System.currentTimeMillis().toInt - start_compute
        }
      }
      block_num += 1
      pruning_rates = pruning_rates :+ pruning_subset_key.length * 100 / sub_num.toDouble
      pruning_num = pruning_num :+ pruning_subset_key.length
    }
    all_time = System.currentTimeMillis().toInt - start
  }

  /* --------------------------------------------------------------------------------------------------------------------
    効率化なしの手法
   -------------------------------------------------------------------------------------------------------------------- */
  def BaseLine(app: Int, EntireDF: DataFrame): Unit = {
    sqlContext.udf.register("Engine", new ExperimentEngine)

    // step. 全体データの作成(事前計算)
    EntireDF.createOrReplaceTempView("ALL")
    val AllMap: Map[String, Seq[Double]] =
      execute_all("ALL").collect.map { r =>
        r.toSeq.head.toString -> Seq(r.toSeq(2).toString.toDouble, r.toSeq(2).toString.toDouble)
      }.toMap

    // step. クエリの作成
    val subset_array: Array[String] = get_subset("ALL", "OriginCityName")

    // step. シーケンシャルにクエリを実行
    subset_array.foreach { s_key =>
      EntireDF.filter($"OriginCityName" === s_key).createOrReplaceTempView("Subset")

      val start_udaf = System.currentTimeMillis().toInt
      val mp = execute_udaf("Subset").first().getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換
      udaf_time += System.currentTimeMillis().toInt - start_udaf.toInt

      // step. DataCubeのマージ
      val start_map_merge: Int = System.currentTimeMillis().toInt
      part_cube ++= mp.map { case (k1, mmp) =>
        val m1 = part_cube.getOrElse(k1, Map())
        val merged = m1 ++ mmp.map { case (x_value, v_list) =>
          val ss = m1.getOrElse(x_value, Seq(0D, 0D, 0D))
          val count = ss.head + v_list.head
          val average = (ss.head * ss(1) + v_list.head * v_list(1)) / count.toDouble
          val variance = (ss.head * (ss(2) + ss(1) * ss(1)) + v_list.head * (v_list(2) + v_list(1) * v_list(1))) / count - average * average
          x_value -> Seq(count, average, variance)
        }
        k1 -> merged
      }
      map_merge_time += System.currentTimeMillis().toInt - start_map_merge
    }

    val interval = part_cube.map { case (subset, value_cube) =>
      subset ->
        value_cube.map { case (k1, v) =>
          agg_func match {
            case "AVG" => k1 -> Seq(v(1), v(1))
            case "SUM" => k1 -> Seq(v(1), v(1))
          }
        }
    }
    result_gof = Application.global_outlier(k, AllMap, interval.-("All").toMap).head
    result_lof = LOF.naive_executer(k, interval.-("All").toMap).head
    all_time = System.currentTimeMillis().toInt - start
  }


  /*------------------------------
    過去の使用物
   ------------------------------*/
  def SharePruningOld(): Unit = {
    val read_rdd1 = ReadData.read_2018_compe(sc).map { case (id, shop, ymd, time, people, price, sex, age, tantou) => ReadData.HairSalon(id: String, shop: String, ymd: String, time: String, people: String, price: Int, sex: String, age: String, tantou: String) }.filter(f => f.price > 0)

    // データ数増加
    //val read_rdd2 = read_rdd1.union(read_rdd1).union(read_rdd1).union(read_rdd1).union(read_rdd1)
    val read_rdd = read_rdd1 //.union(read_rdd1).union(read_rdd1).union(read_rdd1).union(read_rdd1)


    sqlContext.udf.register("Engine", new ExperimentEngine) // step3. UDAFの登録

    read_rdd.randomSplit(rates).foreach { rdd_part => //step4. UDAFの実行 <= 重い
      val start_todf: Int = System.currentTimeMillis().toInt
      if (subset_key.isEmpty) {
        rdd_part.toDF.createOrReplaceTempView("sample")
      }
      else {
        rdd_part.filter { row => !pruning_subset_key.contains(row.shop) }.toDF.createOrReplaceTempView("sample")
      }

      todf_time += System.currentTimeMillis().toInt - start_todf

      if (pruning_subset_key.length != sub_num - k) {
        val start_udaf = System.currentTimeMillis().toInt
        val mp = sqlContext
          .sql("SELECT Engine(shop, ymd, price) from sample") // (region, cate1, price)(shop, ymd, price)
          .first()
          .getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換

        udaf_time += System.currentTimeMillis().toInt - start_udaf.toInt

        val start_map_merge: Int = System.currentTimeMillis().toInt
        part_cube ++= mp.map { case (k1, mmp) =>
          val m1 = part_cube.getOrElse(k1, Map())
          val merged = m1 ++ mmp.map { case (x_value, v_list) =>
            val ss = m1.getOrElse(x_value, Seq(0D, 0D, 0D))
            val count = ss.head + v_list.head
            val average = (ss.head * ss(1) + v_list.head * v_list(1)) / count.toDouble
            val variance = (ss.head * (ss(2) + ss(1) * ss(1)) + v_list.head * (v_list(2) + v_list(1) * v_list(1))) / count - average * average
            x_value -> Seq(count, average, variance)
          }
          k1 -> merged
        }
        map_merge_time += System.currentTimeMillis().toInt - start_map_merge

      }

      val start_compute: Int = System.currentTimeMillis().toInt
      val interval = part_cube.map { case (subset, value_cube) =>
        subset ->
          value_cube.map { case (k1, v) =>
            if (block_num != pertition - 1) {
              // 集約関数: AVG
              val interval_avg = Math.sqrt(z_p * v(2).toString.toDouble / v.head.toString.toDouble)
              k1 -> Seq(v(1) + interval_avg, v(1) - interval_avg)
              /* // 集約関数: SUM
              val interval_sum = Math.sqrt(Math.sqrt(z_p * v(2).toString().toDouble * v(0).toString().toDouble))
              (k1 -> Seq(v(1) + interval_sum, v(1) - interval_sum))
              */
            }
            else {
              // 集約関数: AVG
              k1 -> Seq(v(1), v(1))
              /* // 集約関数: SUM
              (k1 -> Seq(v(1), v(1)))
              */
            }
          }
      }

      val flg: Int = 1
      if (flg == 1) {
        val result12 = Application.global_outlier(k, interval.get("All").toSeq.head, interval.-("All").toMap)
        result_gof = result12.head
        subset_key = result_gof.map(f => f._1) :+ "All"
        pruning_subset_key = pruning_subset_key ::: result12(1).map(f => f._1)
        pruning_rates = pruning_rates :+ pruning_subset_key.length * 100 / sub_num.toDouble
        pruning_num = pruning_num :+ pruning_subset_key.length
        saa = saa :+ subset_key
        part_cube.retain((k, _) => subset_key.contains(k))
      }
      else {
        result_gof = Application.global_outlier(k, interval.get("All").toSeq.head, interval.-("All").toMap).head
        saa = saa :+ result_gof.map { f => f._1 }
      }
      block_num += 1
      compute_time += System.currentTimeMillis().toInt - start_compute
      rap_time = rap_time :+ (System.currentTimeMillis - start)

    }

  }

  def ShareOld(): Unit = {
    //step1. データ読み込み・データフレーム化  step2. 仮想的なviewの作成
    // '17 copetition data
    // val read_rdd = read_2017_compe(sc).map { case (id, item_id, month, price, num, sex, age, region, cate1, cate2) => fashion_EC(id: Int, item_id: Int, month: String, price: Int, num: Int, sex: Int, age: String, region: String, cate1: String, cate2: String) }.filter(f => f.price > 0)
    // '18 copetition data
    val read_rdd1 = ReadData.read_2018_compe(sc).map { case (id, shop, ymd, time, people, price, sex, age, tantou) => ReadData.HairSalon(id: String, shop: String, ymd: String, time: String, people: String, price: Int, sex: String, age: String, tantou: String) }.filter(f => f.price > 0)

    // データ数増加
    //val read_rdd2 = read_rdd1.union(read_rdd1).union(read_rdd1).union(read_rdd1).union(read_rdd1)
    val read_rdd = read_rdd1 //.union(read_rdd1).union(read_rdd1).union(read_rdd1).union(read_rdd1)

    sqlContext.udf.register("Engine", new ExperimentEngine)
    read_rdd.toDF.createOrReplaceTempView("sample")

    val t_2 = System.currentTimeMillis
    part_cube ++= sqlContext
      .sql("SELECT Engine(shop, ymd, price) from sample")
      .first()
      .getMap[String, Map[String, Seq[Double]]](0) //UDAFの実行 + MaP型への変換
    udaf_time += System.currentTimeMillis.toInt - t_2.toInt

    val interval = part_cube.map { case (subset, value_cube) =>
      subset ->
        value_cube.map { case (k1, v) =>
          // 集約関数: AVG
          k1 -> Seq(v(1), v(1))
          /* // 集約関数: SUM
          (k1 -> Seq(v(1), v(1)))
          */
        }
    }
    result_gof = Application.global_outlier(k, interval.get("All").toSeq.head, interval.-("All").toMap).head
    Evaluate.currect_results(1, result_gof)
    subset_key = result_gof.map(f => f._1) :+ "All"
  }
}