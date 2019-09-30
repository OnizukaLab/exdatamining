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
    sqlContext.read.
      format("parquet").
      load("../data/f_2_%s/" format i)
  }

  // 天文台データ
  def pdr1_all(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.format("parquet")
      .load("hdfs:///user/matsumoto/joined").sample(0.0001)
      //.load("./src/data/pdr1_sample")
  }

  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------

  // データ読み込み (Flight data)
  def read_block_flight(sqlContext: SQLContext, i: Int): DataFrame = {
    sqlContext.read.
      format("parquet").
      load("../data/f_2_%s/" format i)
  }

  def read_parquet_flight(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.
      format("parquet")
      .load("./src/data/flights/")
      //.load("hdfs:///user/matsumoto/flight/all/")
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
