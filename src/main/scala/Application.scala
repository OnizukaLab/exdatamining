package udafApp

import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{DataFrame, Row, SQLContext}

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
    val under_threshold: Double = dev_df.head(k).last(2).toString.toDouble //todo: error
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

  /* LOF for dataframe ----------
  0. 部分データ間・次元毎の距離計算
  1. 部分データ間の距離計算
  2. 近傍探索
  3. Lrd の計算
  4. LOF の計算
  5. 返り値の設定
  ------------------------------*/
  def lof(sqlContext: SQLContext, k: Int, x: String, agg_func: String, subset: String, df: DataFrame): List[List[(String, (Double, Double))]] = {
    val n: Int = 10 //LOF 計算の近傍数
    import sqlContext.implicits._
    // step. 1
    val mirror = df.withColumnRenamed(subset, "s")
      .withColumnRenamed("count", "n_count").withColumnRenamed("sum", "n_sum")
      .withColumnRenamed("avg", "n_avg").withColumnRenamed("variance", "n_variance")
      .withColumnRenamed("avg_upper", "n_avg_upper").withColumnRenamed("avg_lower", "n_avg_lower").toDF()

    val dist_df = df.join(mirror, Seq(x)).where(df(subset) =!= mirror("s"))
      .withColumn("dist_upper", calc_dev('avg, 'avg, 'n_avg, 'n_avg)(0))
      .withColumn("dist_lower", calc_dev('avg, 'avg, 'n_avg, 'n_avg)(1))
      .withColumn("pow(dist_upper)", 'dist_upper * 'dist_upper)
      .withColumn("pow(dist_lower)", 'dist_lower * 'dist_lower)
      .groupBy(subset, "s").agg("pow(dist_upper)" -> "sum", "pow(dist_lower)" -> "sum").orderBy($"sum(pow(dist_lower))")

    val dist_map = dist_df.rdd.map { case Row(p1: String, p2: String, upper: Double, lower: Double) =>
      p1 -> (p2 -> (upper, lower))
    }.groupByKey.mapValues(_.toMap).collectAsMap()

    // step. 2
    val nearlest_map = dist_map.map { case (key, map) =>
      val threthold = map.values.toList.sorted.apply(n - 1)._1
      key -> map.filter(f => f._2._1 <= threthold)
    }

    // step. 3
    val lrd_map = nearlest_map.map { case (key, map) =>
      val a = map.values.toList.unzip match {
        case (upp, low) =>
          (upp.length / upp.sum, low.length / low.sum)
      }
      key -> (map.keys, a)
    }

    // step. 4
    val lof_sort_list = lrd_map.map { case (key, map) =>
      var avg_lrd_upper = 0.0
      var avg_lrd_lower = 0.0
      map._1.foreach { s =>
        avg_lrd_upper += lrd_map(s)._2._1
        avg_lrd_lower += lrd_map(s)._2._2
      }
      key -> (avg_lrd_upper / map._1.toList.length / map._2._2, avg_lrd_lower / map._1.toList.length / map._2._1)
    }.toList.sortBy(_._2).reverse

    // step. 5
    List[List[(String, (Double, Double))]](
      lof_sort_list.slice(0, k),
      lof_sort_list.slice(k, lof_sort_list.size)
    )
  }

  /* ------------------------------
    udf
   ------------------------------ */
  def isNull(v: String): Double = Option(v) match {
    case Some(x) => v.toString.toDouble
    case None =>
      println("None exits!")
      0.0
  }

  val calc_dev = udf { (u: String, l: String, all_u: String, all_l: String) =>
    val u1 = isNull(u)
    val l1 = isNull(l)
    val zero_flg = (u1.toDouble - all_l.toDouble) * (l1.toDouble - all_u.toDouble)

    Array(
      List(abs(u1.toDouble - all_l.toDouble), abs(l1.toDouble - all_u.toDouble), 0.0).max, //乖離度の上限
      zero_flg match {
        case z if z <= 0 => 0.0
        case z if z > 0 => List(abs(u1.toDouble - all_u.toDouble), abs(l1.toDouble - all_l.toDouble), abs(u1.toDouble - all_l.toDouble), abs(l1.toDouble - all_u.toDouble)).min
        case _ => 0.0
      } //乖離度の下限
    )
  }


  /* ------------------------------
    実行テスト用
   ------------------------------ */
  def sample_data(sqlContext: SQLContext): DataFrame = {
    sqlContext.read.format("csv").option("header", "true").load("./src/data/test/sample_lof.csv")
  }

  def test_lof(sqlContext: SQLContext, k: Int, agg_func: String): Unit = {
    val df = sample_data(sqlContext).withColumnRenamed("True", "subset").withColumnRenamed("y", "avg")

    val ans = lof(sqlContext, 4, "x", agg_func, "subset", df)
    println(ans.head)
  }

}
