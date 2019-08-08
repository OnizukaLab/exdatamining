package udafApp

object photoz_demp {

    case class experiment_data(
        id: Int, item: Int, category: Int, price: Double
        )

    case class photozdemp(
        object_id : Int
        ,photoz_mean : Float
        ,photoz_mode : Float
        ,photoz_median : Float
        ,photoz_best : Float
        ,photoz_mc : Float
        ,photoz_conf_mean : Float
        ,photoz_conf_mode : Float
        ,photoz_conf_median : Float
        ,photoz_conf_best : Float
        ,photoz_risk_mean : Float
        ,photoz_risk_mode : Float
        ,photoz_risk_median : Float
        ,photoz_risk_best : Float
        ,photoz_std_mean : Float
        ,photoz_std_mode : Float
        ,photoz_std_median : Float
        ,photoz_std_best : Float
        ,photoz_err68_min : Float
        ,photoz_err68_max : Float
        ,photoz_err95_min : Float
        ,photoz_err95_max : Float
    )

    def photoz()={
        sc.textFile("hdfs://user/matsumoto/sample_pdr1_wide.photoz_demp").
        map { lines => val elms = lines.split(",")
            val object_id = elms(0).toInt
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
            ,photoz_mean, photoz_mode, photoz_median, photoz_best, photoz_mc
            ,photoz_conf_mean, photoz_conf_mode, photoz_conf_median, photoz_conf_best
            ,photoz_risk_mean, photoz_risk_mode, photoz_risk_median, photoz_risk_best
            ,photoz_std_mean, photoz_std_mode, photoz_std_median, photoz_std_best
            ,photoz_err68_min, photoz_err68_max, photoz_err95_min, photoz_err95_max
        )
      }    
  }
}
