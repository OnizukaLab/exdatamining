package udafApp

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SQLContext}

object photoz_demp {

  case class experiment_data(
                              id: Int, item: Int, category: Int, price: Double
                            )

  case class photozdemp(
                         object_id: Long
                         , photoz_mean: Float
                         , photoz_mode: Float
                         , photoz_median: Float
                         , photoz_best: Float
                         , photoz_mc: Float
                         , photoz_conf_mean: Float
                         , photoz_conf_mode: Float
                         , photoz_conf_median: Float
                         , photoz_conf_best: Float
                         , photoz_risk_mean: Float
                         , photoz_risk_mode: Float
                         , photoz_risk_median: Float
                         , photoz_risk_best: Float
                         , photoz_std_mean: Float
                         , photoz_std_mode: Float
                         , photoz_std_median: Float
                         , photoz_std_best: Float
                         , photoz_err68_min: Float
                         , photoz_err68_max: Float
                         , photoz_err95_min: Float
                         , photoz_err95_max: Float
                       )
    
  case class meas(
                   object_id: Long
                   , meas_value: String
                  )
  case class meas(
                   object_id: Long
                   , meas_value: String
                  )

  
  /* 
    /user/suga/pdr1_hive/pdr1_wide_photoz_demp/pdr1_wide.photoz_demp
    /user/suga/pdr1_hive/pdr1_wide_meas/pdr1_wide.meas
    /user/suga/pdr1_hive/pdr1_wide/forced
  */
  sc.textFile("/user/suga/pdr1_hive/pdr1_wide/forced")
  // 84,017,247
  sc.textFile("/user/suga/pdr1_hive/pdr1_wide_meas/pdr1_wide.meas")
  // 84,042,022
  sc.textFile("/user/suga/pdr1_hive/pdr1_wide_photoz_demp/pdr1_wide.photoz_demp")
  // 52,658,163

  def photoz(sc: SparkContext) = {

    val photoz_demp = sc.textFile("hdfs:///user/matsumoto/sample_pdr1_wide.photoz_demp").
      map { lines =>
        val elms = lines.split(",")
        val object_id = elms(0).toLong
        val photoz_mean = elms(1).toFloat
        val photoz_mode = elms(2).toFloat
        val photoz_median = elms(3).toFloat
        val photoz_best = elms(4).toFloat
        val photoz_mc = elms(5).toFloat
        val photoz_conf_mean = elms(6).toFloat
        val photoz_conf_mode = elms(7).toFloat
        val photoz_conf_median = elms(8).toFloat
        val photoz_conf_best = elms(9).toFloat
        val photoz_risk_mean = elms(10).toFloat
        val photoz_risk_mode = elms(11).toFloat
        val photoz_risk_median = elms(12).toFloat
        val photoz_risk_best = elms(13).toFloat
        val photoz_std_mean = elms(14).toFloat
        val photoz_std_mode = elms(15).toFloat
        val photoz_std_median = elms(16).toFloat
        val photoz_std_best = elms(17).toFloat
        val photoz_err68_min = elms(18).toFloat
        val photoz_err68_max = elms(19).toFloat
        val photoz_err95_min = elms(20).toFloat
        val photoz_err95_max = elms(21).toFloat

        photozdemp(
          object_id
          , photoz_mean, photoz_mode, photoz_median, photoz_best, photoz_mc
          , photoz_conf_mean, photoz_conf_mode, photoz_conf_median, photoz_conf_best
          , photoz_risk_mean, photoz_risk_mode, photoz_risk_median, photoz_risk_best
          , photoz_std_mean, photoz_std_mode, photoz_std_median, photoz_std_best
          , photoz_err68_min, photoz_err68_max, photoz_err95_min, photoz_err95_max
        )
      }

    photoz_demp.registerTempTable("photoz_demp")
    
    val df_meas = sc.textFile("hdfs:///user/matsumoto/sample_pdr1_wide.meas").
      map{lines =>
            meas(lines.split(",")(0).toLong, lines)
          }.toDF
    df_meas.registerTempTable("meas")
    
    val df_forced = sc.textFile("hdfs:///user/matsumoto/sample_pdr1_wide.forced").
      map{lines =>
            forced(lines.split(",")(0).toLong, lines)
          }.toDF
    df_forced.registerTempTable("forced")

    df_forced.
      join( df_meas, df_forced("object_id") === df_meas("object_id"), "left" ).
      join( photoz_demp, df_forced("object_id") === photoz_demp("object_id"), "inner").
      show()

  }
}
