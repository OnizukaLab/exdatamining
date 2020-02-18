package udafApp

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SQLContext}

object ReadData {
  /*---------------------------------------------------------------------------------
  <データ種類>
    data_flg 変数で制御
    * data_flg = 0 : 天文台
    * data_flg = 1 : Flight Delay Data
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
  def read_all_data(sqlContext: SQLContext, data: Int, data_file: String): DataFrame = {
    data match {
      case 0 => pdr1_all(sqlContext)
      case 1 => read_parquet_flight(sqlContext)
      case _ => ???
    }
  }

  def read_block_data(sqlContext: SQLContext, i: Int, data: Int): DataFrame = {
    data match {
      case 0 => pdr1_all(sqlContext)
      case 1 => read_block_flight(sqlContext, i)
    }
  }

  def pdr1_all(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.format("parquet")
      .load("hdfs:///user/matsumoto/joined").sample(0.0001)
  }

  // 天文台データ 
  def read_astro(sqlContext:SQLContext, file_path: String, data_format: String, sample_rate: Double = 1.0, where_clause: String): DataFrame = {
    where_clause match {
      case "" => sqlContext.read.option("header", "true").format(data_format).load(file_path).sample(sample_rate)
      case _ =>  DFFilter(
        sqlContext,
        where_clause,
        sqlContext.read.option("header", "true").format(data_format).load(file_path).sample(sample_rate)
        )
    }
  }

  // 時系列データ
  def TimeSeries(sqlContext: SQLContext, TimeList: Array[String] = Array("00817")): DataFrame = {
    val hdfs_path = "hdfs:///user/furu/naoj/HSC/rerun/s18a_dud/"
    TimeList.map { i =>
      sqlContext.read.format("csv").option("header", "true").load(s"$hdfs_path$i/*/*/csv").withColumn("date_id", lit(i))
    }.reduceLeft((a, b) => a.union(b))
  }

  // データの前処理を必要としている場合に使用する関数
  def DFFilter(sqlContext: SQLContext, where_clause: String, df: DataFrame): DataFrame ={
    df.filter(where_clause)
  }

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------

  // データ読み込み (Flight data)
  def read_block_flight(sqlContext: SQLContext, i: Int): DataFrame = {
    sqlContext.read.
      format("parquet").
      load("./src/resources/flights/f_5_%s/" format i)
  }

  def read_parquet_flight(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.
      format("parquet").load("./src/resources/flights/all/")
      //.load("hdfs:///user/matsumoto/flight/all/")
      //.load("./src/resources/flights/")
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

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
}
