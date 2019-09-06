package udafApp

import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{DataFrame, SQLContext}

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
  def gof(sqlContext: SQLContext, k: Int, agg_func: String, z_p: Double, gof_df: DataFrame, subset: String): List[List[(String, (Double, Double))]] = {
    import sqlContext.implicits._
    // step. 1
    // step. 2
    var dev_df: DataFrame = gof_df.
      withColumn("dev_upper", calc_dev('avg_upper, 'avg_lower, 'all_avg_upper, 'all_avg_lower)(0)).
      withColumn("dev_lower", calc_dev('avg_upper, 'avg_lower, 'all_avg_upper, 'all_avg_lower)(1))
    dev_df = dev_df.groupBy(subset).agg("dev_upper" -> "sum", "dev_lower" -> "sum").orderBy($"sum(dev_upper)".desc)
    // step. 3
    val under_threshold: Double = dev_df.head(k).last(2).toString.toDouble
    // step. 4
    val not_pruning_list: List[(String, (Double, Double))] =
      dev_df.filter($"sum(dev_upper)" > under_threshold).select(subset, "sum(dev_upper)", "sum(dev_lower)").
        rdd.map(r => (r(0).toString, (r(1).toString.toDouble, r(2).toString.toDouble))).collect().toList

    val pruning_list: List[(String, (Double, Double))] =
      dev_df.filter($"sum(dev_upper)" <= under_threshold).select(subset, "sum(dev_upper)", "sum(dev_lower)").
        rdd.map(r => (r(0).toString, (r(1).toString.toDouble, r(2).toString.toDouble))).collect().toList

    // step. 5 List[(String,(Double,Double))]
    return List(
      not_pruning_list,
      pruning_list
    )
  }

  /* ------------------------------
    udf
   ------------------------------ */
  val calc_dev = udf { (u: String, l: String, all_u: String, all_l: String) =>
    val zero_flg = (u.toDouble - all_l.toDouble) * (l.toDouble - all_u.toDouble)

    Array(
      List(abs(u.toDouble - all_l.toDouble), abs(l.toDouble - all_u.toDouble), 0.0).max, //乖離度の上限
      zero_flg match {
        case z if z <= 0 => 0.0
        case z if z > 0 => List(abs(u.toDouble - all_u.toDouble), abs(l.toDouble - all_l.toDouble), abs(u.toDouble - all_l.toDouble), abs(l.toDouble - all_u.toDouble)).min
        case _ => 0.0
      } //乖離度の下限
    )
  }


  /* LOF for dataframe ----------
  1. k近傍との距離の計算
  2. Lrd の計算・LOF の計算
  3. 閾値の計算
  4. 足切りの部分データのkey情報のList化
  5. 返り値の設定
  ------------------------------*/
  def lof(sqlContext: SQLContext, k: Int, agg_func: String, subset: String, df: DataFrame): List[List[(String, (Double, Double))]] = {
    // step. 1
    df.show()


    return List[List[(String, (Double, Double))]]()
  }
}
