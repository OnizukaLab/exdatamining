package udafApp

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SQLContext}

object ReadData {
  /*---------------------------------------------------------------------------------
  <データ種類>
    data_flg 変数で制御
    * data_flg = 1 : Flight Delay Data
    * data_flg = 2 : Port and Commodity Data
    * data_flg = 3 : Border Crossing Data
  --------------------------------------------------------------------------------- */

  /*----------
    UDF
  ----------*/
  private val toInt = udf[Int, String](_.toInt)
  private val toDouble = udf[Double, String](_.toDouble)
  private val toMonth = udf[Int, String](_.split("/")(0).toInt)
  private val toYear = udf[Int, String](_.split("/")(2).slice(0, 4).toInt)

  /*----------
    関数
   ----------*/
  def read_split_data(sqlContext: SQLContext, data_flg: Int, partition: Int): Array[DataFrame] = {
    var BlockDF: Array[DataFrame] = Array.empty[DataFrame]
    (0 until partition).foreach(i =>
      BlockDF = BlockDF :+ sqlContext.read.format("com.databricks.spark.csv").option("header", "true")
        .load("./src/resources/tmp/%s.csv" format i)
    )
    BlockDF
  }

  def read_all_data(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.format("com.databricks.spark.csv").option("header", "true")
      .load("./src/resources/tmp/all.csv")
  }

  /*--------------------
    データサイズの変更用関数
   --------------------*/
  private def IncreseData(data: DataFrame, p: Int): DataFrame = {
    var newDF: DataFrame = data
    for (i <- 2 to p) {
      newDF = newDF.union(data)
    }
    newDF
  }

  def DecreaseData(data: DataFrame): Unit = {
    val decrease_size_list: List[Double] = List[Double](0.0001)
    for (size <- decrease_size_list) {
      println(size)
      //data.sample(false, size).write.csv("sample.csv")
      println(data.sample(false, size).count())
    }
  }

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------

  // データ読み込み (Flight data)
  def read_flight_data(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.
      format("com.databricks.spark.csv").
      option("header", "true").
      load("./src/resources/Flights/test.csv")
  }

  // データ読み込み (Port and Commodity data)
  def read_portcommodity_data(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.
      format("com.databricks.spark.csv").
      option("header", "true").
      load("./src/resources/PortAndCommodity/all.csv")
  }

  // データ読み込み (Border Crossing Entry data)
  def read_bordercrossing_data(sqlContext: SQLContext): DataFrame = {
    val origin: DataFrame = sqlContext.read.
      format("com.databricks.spark.csv").
      option("header", "true").
      load("./src/resources/BorderCrossingEntry/sample.csv")
    val return_df = origin.
      withColumn("Month", toMonth(origin("Date"))).
      withColumn("Year", toYear(origin("Date")))
    return_df
  }

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------

  // データ読み込み (2018 Competition)
  def read_2018_compe(sc: SparkContext): RDD[(String, String, String, String, String, Int, String, String, String)] = {
    sc.textFile("./src/resources/hairsalon/entire.csv").
      filter(line => !line.contains("ID")).
      map { lines =>
        val elms = lines.split(",")
        val id: String = elms(0)
        val shop: String = elms(2) + "/" + elms(48)
        val ymd: String = elms(3).split("/")(1)
        val time: String = elms(4)
        val people: String = elms(5)
        val price: Int = elms(6).toInt
        val sex: String = elms(47)
        val age: String = elms(48)
        val tantou: String = elms(50)

        (id, shop, ymd, time, people, price, sex, age, tantou)
      }
  }

  // データ読み込み (2017 Competition)
  def read_2017_compe(sc: SparkContext): RDD[(Int, Int, String, Int, Int, Int, String, String, String, String)] = {
    sc.textFile("./src/main/resources/fashionEC/entire.csv").
      filter(line => !line.contains("顧客番号")).
      map { lines =>
        val elms = lines.split(",")
        val id = elms(0).toInt
        val item_id = elms(3).toInt
        val month = elms(8).split("-")(1)
        val price = elms(10).toInt
        val num = elms(11).toInt
        val sex = elms(14).toInt
        val age = elms(15)
        val region = elms(18) + elms(14)
        val cate1 = elms(24)
        val cate2 = elms(25)

        (id, item_id, month, price, num, sex, age, region, cate1, cate2)
      }
  }

  // データ読み込み (人口データ)
  def read_experiment_data(sc: SparkContext): RDD[(Int, Int, Int, Double)] = {
    // sample.csv or test.csv
    sc.textFile("./src/main/resources/sample/test.csv").
      filter(line => !line.contains("id")).
      map { lines =>
        val elms = lines.split(",")
        val id = elms(0).toInt
        val item = elms(1).toInt
        val category = elms(2).toInt
        val price = elms(3).toDouble
        (id, item, category, price)
      }
  }

  case class experiment_data(id: Int, item: Int, category: Int, price: Double)

  case class fashion_EC(id: Int, item_id: Int, month: String, price: Int, num: Int, sex: Int, age: String, region: String, cate1: String, cate2: String)

  case class HairSalon(id: String, shop: String, ymd: String, time: String, people: String, price: Int, sex: String, age: String, tantou: String)

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
}
