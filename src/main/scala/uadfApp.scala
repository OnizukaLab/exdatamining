package udafApp

import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object udafApp {
  /*------------------------------
    SparkContext インスタンスの生成
   ------------------------------*/
  val conf = new SparkConf().setAppName("EDAEngine").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  import sqlContext.implicits._

  /*-----------------------------------------
    実験で使用するパラメータの設定
      * sub_num : 部分データの総数
      * z_p     : 95％信頼区間のZ_p
      * k       : 探索する上位の件数 (Top-k)
      * per     : データ分割数
      * rates   : データ分割の粒度(分割率)
   -----------------------------------------*/
  val sub_num: Int = 316
  var k: Int = 10
  var datasize: Int = 1
  val pertition: Int = 2
  val rates: Array[Double] = Array.fill(pertition)(1.0 / pertition)
  val z_p: Double = 1.96 * 1.96

  /* -----------------------------------------
    TODO: Set Query's Parameter 
   -----------------------------------------*/
  var s: String = "object_id"
  var x: String = "Quarter"
  var y: String = "DepDelay"
  var agg_func: String = "AVG"
  var data_file: String = "hdfs:///user/matsumoto/joined"
  var data_format: String = "csv"
  var target_col: Array[String] = Array("meas_rcmodel_mag", "meas_rcmodel_mag_err")
  var sampling_rate: Double = 1.0
  var output_file: String = "" //TODO: set default file

  /* -------------
   コマンドライン引数の処理
  ------------- */
  private def cla(args: Array[String]): Unit = {
    args.foreach { e =>
      e.split("=")(0) match {
        case "subset" => s = e.split("=")(1)
        case "data_file" => data_file = e.split("=")(1)
        case "data_format" => data_format = e.split("=")(1)
        case "k" => k = e.split("=")(1).toInt
        case "target_column" =>
          target_col = Array.empty[String]
          e.split("=")(1).split(",").foreach { c =>
            target_col = target_col :+ c
          }
        case "x" => x = e.split("=")(1)
        case "y" => y = e.split("=")(1)
        case "agg_func" => agg_func = e.split("=")(1)
        case "sampling_rate" => sampling_rate = e.split("=")(1).toDouble
        case "output_file" => output_file = e.split("=")(1)
        case _ => println("error: command line arguments faults")
      }
    }
  }

  /*------------------------------
    パラメータの設定・初期化
   ------------------------------*/
  var block_num: Int = 0
  var result_gof: List[(String, (Double, Double))] = List.empty[(String, (Double, Double))]
  var result_lof: List[(String, Double)] = List.empty[(String, Double)]
  var subset_key: List[String] = List.empty[String]
  var pruning_subset_key: List[String] = List.empty[String]
  val part_cube = scala.collection.mutable.HashMap.empty[String, Map[String, Seq[Double]]]
  var saa: List[List[String]] = List.empty[List[String]]
  var pruning_rates: List[Double] = List.empty[Double]
  var pruning_num: List[Int] = List.empty[Int]

  /*------------------------------
    時間計測用のパラメータの初期化
   ------------------------------*/
  var udaf_time: Int = 0
  var map_merge_time: Int = 0
  var todf_time: Int = 0
  var compute_time: Int = 0
  var rap_time: List[Any] = List[Any]()
  var all_time: Int = 0
  val wait_time: Int = 30000
  var start: Int = System.currentTimeMillis().toInt
  val k_list: List[Int] = List[Int](1, 5, 10, 15, 20, 25, 30)
  val size_list: List[Int] = List[Int](2, 4, 6, 8, 10)

  /*------------------------------
    パラメータ初期化用関数
   ------------------------------*/
  private def initparameter(): Unit = {
    block_num = 0
    result_gof = List.empty[(String, (Double, Double))]
    result_lof = List.empty[(String, Double)]
    subset_key = List.empty[String]
    pruning_subset_key = List.empty[String]
    part_cube.clear()
    saa = List.empty[List[String]]
    pruning_rates = List.empty[Double]
    pruning_num = List.empty[Int]

    udaf_time = 0
    map_merge_time = 0
    todf_time = 0
    compute_time = 0
    rap_time = List[Any]()
    all_time = 0
    start = System.currentTimeMillis().toInt
  }

  /*---------------------------------------------------------------------------------
  <手法>
    method 変数で制御
    * 提案手法　　　　　:　SharePruning()
    * クエリ共有化のみ　:　Share()
    * 枝刈りのみ　　　　:　Pruning()
    * ベースライン　　　:　BaseLine()

  <Application>
    app 変数で制御
    * app = 1 : Global Outlier Factor
    * app = 2 : LOF(Local Outlier Factor
    * app = 3 : seedb ?
    * app = 4 : 回帰分析 (Regression Anaysis)

  <データ種類>
    data 変数で制御
    * data = 0 : 天文台データ
    * data = 1 : Flight Delay Data
  --------------------------------------------------------------------------------- */
  def main(args: Array[String]) {
    val app: Int = 2
    val data: Int = 0
    val method: String = ("Baseline", "Share", "Pruning", "SharePruning")._2
    val output_ver: String = ("Experiment", "Correct")._1
    cla(args)


/*
    data match {
      case 0 => astro_analysis(sqlContext, data, method)
      case 1 => data_analysis(sqlContext, data, app, method)
    }
*/
    Application.test_lof(sqlContext, k= 10, agg_func)

    res_output(app, data, method, output_ver) // 結果の出力

    sc.stop
  }

  /* -------------
     天文台データ用
    ------------- */
  def astro_analysis(sqlContext: SQLContext, data: Int, method: String): Unit = {
    sqlContext.read.format(data_format).load(data_file).
      filter($"meas_rcmodel_mag" < 24).sample(sampling_rate).
      createOrReplaceTempView("astro")

    val df = hci_plot("astro")

    var res_lof = List[List[(String, Double)]]()

    res_lof = Application.lof(sqlContext, k, target_col, agg_func, s, df)

    result_lof = res_lof.head.take(k)

    //visualize.visualize_2d(sqlContext, df, result_lof, target_col)
    val outlier_df = df.withColumn("OutlierFlg", 'object_id.isin(result_lof.map { case (k, lof) => k }: _*))
    //outlier_df.write.option("header", "true").csv("./ResLOF.csv")

    all_time = System.currentTimeMillis().toInt - start
  }

  /* -------------
    udf
   ------------- */
  private def make_sum_interval = (c: String, v: String) => {
    math.sqrt(c.toDouble * z_p * v.toDouble)
  }

  private val sum_interval = udf(make_sum_interval)

  private def make_avg_interval = (c: String, v: String) => {
    math.sqrt(z_p * v.toDouble / c.toDouble)
  }

  private val avg_interval = udf(make_avg_interval)

  /* -------------
    output
   ------------- */
  private def outlier_output(app: Int, df: DataFrame): Unit ={
    val outlier_df = df.withColumn("OutlierFlg", 'object_id.isin(result_lof.map { case (k, lof) => k }: _*))
    outlier_df.write.option("header", "true").format("csv").mode("overwrite").save(output_file)
  }

  private def res_output(app: Int, data: Int, method: String, output_ver: String): Unit = {
    output_ver match {
      case "Experiment" =>
        for (app <- 1 to 1) { //TODO: set app
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
        //println(todf_time, udaf_time, map_merge_time, compute_time)
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
        println("all_time : %s" format all_time)
        println("pruning_rates : %s" format pruning_rates)
        println("pruning_num : %s" format pruning_num)
        println("rap_time : %s" format rap_time)
        println("--------------")
        println("gof_results: %s" format result_gof.map(_._1))
        println("lof_results: %s" format result_lof.map(_._1))
        println("pruning_subset: %s" format pruning_subset_key)
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")

      case "Correct" =>
        Evaluate.currect_results(app, result_gof)

      case _ => ???
    }
  }

  /* -------------
    SQL statement and Execution Part
   ------------- */
  private def hci_plot(table: String): DataFrame = {
    sqlContext.sql("SELECT %s, %s, %s FROM %s" format(s, target_col(0), target_col(1), table))
  }

  // 全体平均の作成（for gof）
  private def execute_all(table: String): DataFrame = {
    sqlContext.sql(
      "SELECT %s, count(*) as all_count, avg(%s) as all_avg, sum(%s) as all_sum, variance(%s) as all_variance FROM %s GROUP BY %s" format(x, y, y, y, table, x)
    )
  }

  // 部分データも含めた Data cube の作成
  private def execute_all_subset_query(table: String): DataFrame = {
    sqlContext.sql(
      "SELECT %s, %s, count(*) as count, sum(%s) as sum, variance(%s) as variance, avg(%s) as avg FROM %s GROUP BY %s, %s" format(s, x, y, y, y, table, s, x)
    )
  }

  // 部分データ 1 つに flitering
  private def execute_subset_query(table: String, where: String): DataFrame = {
    sqlContext.sql(
      "SELECT %s, %s, count(*) as count, sum(%s) as sum, variance(%s) as variance, avg(%s) as avg FROM %s WHERE %s = \"%s\" GROUP BY %s, %s" format(s, x, y, y, y, table, s, where, s, x)
    )
  }

  // データに含まれる部分データの総数を取得
  private def get_subset(table: String, where: String): Array[String] = {
    sqlContext.sql(
      "SELECT %s FROM %s GROUP BY %s" format(where, table, where)
    ).collect.map(_ (0).toString)

  }

  /* ---------------------------------------------------------------------------------
    クエリ共有化 & 枝刈り
   --------------------------------------------------------------------------------- */
  def SharePruning(sqlContext: SQLContext, app: Int, data: Int, all_df: DataFrame, Forall_df: DataFrame): Unit = {
    var cube_df: DataFrame = sqlContext.emptyDataFrame
    val MergeValue = new MergeValue
    val MergeVariance = new MergeVariance

    Array[Int](0, 1).foreach { i =>
      val df = ReadData.read_block_data(sqlContext, i, data)

      if (pruning_subset_key.isEmpty) {
        df.createOrReplaceTempView("block")
      }
      else {
        df.filter(!$"OriginCityName".isin(pruning_subset_key: _*)).createOrReplaceTempView("block") //TODO: 部分データの属性名の指定
      }

      val sample_df = execute_all_subset_query("block")

      if (cube_df == sqlContext.emptyDataFrame) {
        cube_df = sample_df
      }
      else {
        cube_df = cube_df.union(sample_df) //.na.fill(0)
          .groupBy(s, x)
          .agg(MergeValue('count) as "count", MergeValue('sum) as "sum", MergeVariance('count, 'avg, 'variance) as "variance")
          .withColumn("avg", 'sum / 'count)
      }

      var res_gof = List[List[(String, (Double, Double))]]()
      var res_lof = List[List[(String, Double)]]()

      val future_gof = Future {
        res_gof = Application.gof(
          sqlContext, k, agg_func, z_p, s,
          cube_df
            .withColumn("avg_upper", $"avg" + avg_interval('count, 'variance))
            .withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))
            .select(s, x, "avg_upper", "avg_lower").
            join(
              Forall_df.drop("all_sum", "all_avg", "all_count", "all_variance"),
              Seq(x)
            )
        )
      }
      val future_lof = Future {
        res_lof = Application.lof(
          sqlContext, k, target_col, agg_func, s,
          execute_all_subset_query("all")
            .withColumn("avg_upper", $"avg" + avg_interval('count, 'variance))
            .withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))
        )
      }

      val ff = future_gof.zip(future_lof)
      while (!ff.isCompleted) {}
      result_gof = res_gof.head.take(k)
      result_lof = res_lof.head.take(k)

      pruning_subset_key = (pruning_subset_key ::: res_gof(1).map(f => f._1).intersect(res_lof(1).map(f => f._1))).distinct
      pruning_rates = pruning_rates :+ pruning_subset_key.length * 100 / sub_num.toDouble
      pruning_num = pruning_num :+ pruning_subset_key.length

      cube_df = cube_df.filter(!$"OriginCityName".isin(pruning_subset_key: _*)) //TODO: 部分データの属性名の指定
    }

    all_time = System.currentTimeMillis().toInt - start
  }

  /* ---------------------------------------------------------------------------------
    クエリ共有化のみ行う手法
   --------------------------------------------------------------------------------- */
  def Share(sqlContext: SQLContext, app: Int, data: Int, ALL_DF: DataFrame, Forall_df: DataFrame): Unit = {

    ALL_DF.randomSplit(Array[Double](1.0)).head
      .createOrReplaceTempView("share")

    val sample_df = execute_all_subset_query("share").
      withColumn("avg_upper", $"avg" + avg_interval('count, 'variance)).
      withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))

    var res_gof = List[List[(String, (Double, Double))]]()
    var res_lof = List[List[(String, Double)]]()

    val future_gof = Future {
      res_gof = Application.gof(
        sqlContext, k, agg_func, z_p, s,
        sample_df.drop("sum", "avg", "count", "variance").
          join(
            Forall_df.drop("all_sum", "all_avg", "all_count", "all_variance"),
            Seq(x)
          )
      )
    }
    val future_lof = Future {
      res_lof = Application.lof(
        sqlContext, k, target_col, agg_func, s,
        execute_all_subset_query("all")
          .withColumn("avg_upper", $"avg" + avg_interval('count, 'variance))
          .withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))
      )
    }

    val ff = future_gof.zip(future_lof)
    while (!ff.isCompleted) {}
    result_gof = res_gof.head.take(k)
    result_lof = res_lof.head.take(k)


    all_time = System.currentTimeMillis().toInt - start
  }

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------

  /* --------------------------------------------------------------------------------------------------------------------
    枝刈りのみ行う手法
   -------------------------------------------------------------------------------------------------------------------- */
  def Pruning(sqlContext: SQLContext, app: Int, data: Int, Forall_df: DataFrame): Unit = {
    var cube_df: DataFrame = sqlContext.emptyDataFrame
    val MergeValue = new MergeValue
    val MergeVariance = new MergeVariance

    Array[Int](0, 1).foreach { i =>
      val df = ReadData.read_block_data(sqlContext, i, data)

      if (pruning_subset_key.isEmpty) {
        df.createOrReplaceTempView("block")
      }
      else {
        df.filter(!$"OriginCityName".isin(pruning_subset_key: _*)).createOrReplaceTempView("block") //TODO: 部分データの属性名の指定
      }

      val subset_array: Array[String] = get_subset("block", s)
      subset_array.foreach { s_key =>
        val s_df = execute_subset_query("block", s_key)
        if (cube_df == sqlContext.emptyDataFrame) {
          cube_df = s_df
        }
        else {
          cube_df = cube_df.union(s_df)
        }
      }
      cube_df = cube_df
        .groupBy(s, x)
        .agg(MergeValue('count) as "count", MergeValue('sum) as "sum", MergeVariance('count, 'avg, 'variance) as "variance")
        .withColumn("avg", 'sum / 'count)

      val res_gof = Application.gof(
        sqlContext, k, agg_func, z_p, s,
        cube_df
          .withColumn("avg_upper", $"avg" + avg_interval('count, 'variance))
          .withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))
          .select(s, x, "avg_upper", "avg_lower").
          join(
            Forall_df.drop("all_sum", "all_avg", "all_count", "all_variance"),
            Seq(x)
          )
      )
      result_gof = res_gof.head.take(k)

      pruning_subset_key = (pruning_subset_key ::: res_gof.last.map(f => f._1)).distinct
      pruning_rates = pruning_rates :+ pruning_subset_key.length * 100 / sub_num.toDouble
      pruning_num = pruning_num :+ pruning_subset_key.length
      cube_df = cube_df.filter(!$"OriginCityName".isin(pruning_subset_key: _*))
    }

    //result_lof = LOF.naive_executer(k, interval.-("All").toMap).head

    all_time = System.currentTimeMillis().toInt - start
  }

  /* --------------------------------------------------------------------------------------------------------------------
    効率化なしの手法
   -------------------------------------------------------------------------------------------------------------------- */
  def BaseLine(sqlContext: SQLContext, app: Int, data: Int, Forall_df: DataFrame): Unit = {
    // step. 部分データの総数を取得
    val subset_array: Array[String] = get_subset("all", s)
    var df = sqlContext.emptyDataFrame

    val test_subset_array: Array[String] = Array[String]("a")

    // step. シーケンシャルにクエリを実行
    subset_array.foreach { s_key =>
      val s_df = execute_subset_query("ALL", s_key)
      if (df == sqlContext.emptyDataFrame) {
        df = s_df
      }
      else {
        df = df.union(s_df)
      }
    }
    df = df.
      withColumn("avg_upper", $"avg" + avg_interval('count, 'variance)).
      withColumn("avg_lower", $"avg" - avg_interval('count, 'variance))

    result_gof = Application.gof(
      sqlContext, k, agg_func, z_p, s,
      df.drop("sum", "avg", "count", "variance").
        join(
          Forall_df.drop("all_sum", "all_avg", "all_count", "all_variance"),
          Seq(x)
        )
    ).head.take(k)

    all_time = System.currentTimeMillis().toInt - start
  }

  /* -------------
    Flight data 用の実行関数
   ------------- */
  def data_analysis(sqlContext: SQLContext, data: Int, app: Int, method: String): Unit = {
    // Read Data
    val ALL_DF: DataFrame = ReadData.read_all_data(sqlContext, data, data_file)
    ALL_DF.createOrReplaceTempView("all")

    // Make all data result (Dataframe)
    val Forall_df = execute_all("all").
      withColumn("all_avg_upper", $"all_avg" + avg_interval('all_count, 'all_variance)).
      withColumn("all_avg_lower", $"all_avg" - avg_interval('all_count, 'all_variance))

    k = (1, 5, 10, 15, 20, 25, 30, 316)._3
    datasize = (1, 2, 4, 6, 8, 10)._1
    initparameter() // 実験用パラメータの初期化

    /*-------------
      手法選択
    --------------*/
    method match {
      case "SharePruning" =>
        SharePruning(sqlContext, app, data, ALL_DF, Forall_df)
      case "Share" =>
        Share(sqlContext, app, data, ALL_DF, Forall_df)
      case "Pruning" =>
        Pruning(sqlContext, app, data, Forall_df)
      case "Baseline" =>
        BaseLine(sqlContext, app, data, Forall_df)
      case _ =>
        println("- Missing Select Method -")
    }

  }

}