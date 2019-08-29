package udafApp

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SQLContext}

/*----------
 天文台データ
----------*/
object ReadPDR1 {
  /*----------
   設定
  ----------*/
  val joined_file_path: String = "hdfs:///user/matsumoto/joined"
  val forced_file: String = "/user/suga/pdr1_hive/pdr1_wide/forced"
  val meas_file: String = "/user/suga/pdr1_hive/pdr1_wide_meas/pdr1_wide.meas"
  val photozdemp_file: String = "/user/suga/pdr1_hive/pdr1_wide_photoz_demp/pdr1_wide.photoz_demp"

  /*----------
   UDF
  ----------*/
  private val toInt = udf[Int, String](_.toInt)
  private val toDouble = udf[Double, String](_.toDouble)
  private val toLong = udf[Long, String](_.toLong)
  def forCood = (s: String) =>{
    s.split(", ").map{
      _.diff("(").diff(")").diff("[").diff("]").toDouble
    }
  }
  udf(forCood)

  /*----------
   関数
  ----------*/
  def stronomical(sqlContext: SQLContext): DataFrame = {
    //val sqlContext = new SQLContext(sc)
    sqlContext.read.format("parquet").load(joined_file_path)
  }

}
