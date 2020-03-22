package udafApp

object LOF {
  /* --------------------------------------------------------------------------------------------------------------------
    input
      1. k : 上位 k 件
      2. subset : 部分データ -> x軸の値 -> y軸の値の範囲[max, min]
        ex. AA -> (Jan -> (max, min))

    output: List
      1. 閾値以上 である　部分データ -> LOF 値の範囲 (max, min)
      2. 閾値未満 である　部分データ -> LOF 値の範囲 (max, min)
   --------------------------------------------------------------------------------------------------------------------*/
  val n: Int = 10

  // --------------------------------------------------------------------------------------------------------------------
  // 実行箇所
  // --------------------------------------------------------------------------------------------------------------------
  def naive_executer(k: Int, subset: Map[String, Map[String, Seq[Double]]]): List[List[(String, (Double, Double))]] = {

    val k_nearest_distance_map = calc_dist(subset)
    val lof_value_map = calc_lof_value(k_nearest_distance_map)

    List(
      lof_value_map.slice(0, k),
      lof_value_map.slice(k, lof_value_map.size)
    )
  }

  // --------------------------------------------------------------------------------------------------------------------
  // すべてのデータ間のの距離計算
  // --------------------------------------------------------------------------------------------------------------------
  def calc_dist(subset: Map[String, Map[String, Seq[Double]]]): Map[String, (Seq[String], Double)] = {
    var distance_map: Map[(String, String), Double] = Map.empty[(String, String), Double]
    for ((key1, xy_map1) <- subset; (key2, xy_map2) <- subset) {
      if (key1 != key2) {
        distance_map ++= Map(
          (key1, key2) -> math.sqrt(
            (xy_map1.keys.toList ++ xy_map2.keys.toList).distinct.map(k_key =>
              math.pow(
                xy_map1.getOrElse(k_key, Seq(0D, 0D, 0D))(1) - xy_map2.getOrElse(k_key, Seq(0D, 0D, 0D))(1),
                2
              )
            ).sum
          )
        )
      }
    }

    val k_distance: Map[String, (Seq[String], Double)] = subset.keys.map { kk =>
      val kk_dist_map = distance_map.filterKeys(_._1 == kk).map { case (a, b) => a._2 -> b }
      val threshold = kk_dist_map.values.toList.sorted.apply(n - 1)
      //.reverse(n)
      val kk_nearest_dist = kk_dist_map.filter(f => f._2 <= threshold)

      kk -> (kk_nearest_dist.keys.toSeq, kk_nearest_dist.values.sum / kk_nearest_dist.size)
    }.toMap

    k_distance
  }

  // --------------------------------------------------------------------------------------------------------------------
  // データ毎にLOF計算
  // --------------------------------------------------------------------------------------------------------------------
  def calc_lof_value(k_nearest_distance_map: Map[String, (Seq[String], Double)]): List[(String, (Double, Double))] = {

    val lof_value_map: List[(String, (Double, Double))] =
      k_nearest_distance_map.map { case (a, (knn, d)) =>
        val a_lrd: Double = 1.0 / d
        var knn_lrd: Double = 0.0
        knn.foreach { b =>
          knn_lrd += 1.0 / k_nearest_distance_map.get(b).map { case (knn_knn, knn_knn_d) => knn_knn_d }.head
        }
        knn_lrd /= knn.size
        a -> (knn_lrd / a_lrd, knn_lrd / a_lrd)
      }.toList.sortBy(_._2).reverse

    lof_value_map
  }

  // --------------------------------------------------------------------------------------------------------------------
  // LOF の動作確認
  // --------------------------------------------------------------------------------------------------------------------
  def test_execute(k: Int): List[(String, (Double, Double))] = {
    val subset = sample_data()

    val k_nearest_distance_map = calc_dist(subset)
    val lof_value_map = calc_lof_value(k_nearest_distance_map)

    lof_value_map.slice(0, k)
  }

  def sample_data(): Map[String, Map[String, Seq[Double]]] = {
    /*
        商品A	商品B	商品C	商品D	商品E	商品F	商品G	商品H	商品I	商品J	全体平均
    Dec	0.08	0.339805825	0.316666667	0.328813559	0.333333333	0.043668122	0	0.010033445	0	0.015923567	0.171196611
    Jan	0.1	  0.323624595	0.303333333	0.311864407	0.3	0.069868996	0.02	0.040133779	0.033333333	0.038216561	0.181786092
    Feb	0.34	0.242718447	0.243333333	0.230508475	0.233333333	0.139737991	0.086666667	0.100334448	0.1	0.117834395	0.160960113
    Mar	0.459893048	0.064724919	0.083333333	0.077966102	0.1	0.240174672	0.233333333	0.234113712	0.233333333	0.222929936	0.154959407
    Apr	0.026737968	0.022653722	0.036666667	0.040677966	0.033333333	0.222707424	0.316666667	0.294314381	0.3	0.286624204	0.162019061
    May	0.026737968	0.006472492	0.016666667	0.010169492	0	0.283842795	0.343333333	0.321070234	0.333333333	0.318471338	0.169078715
    */
    val toy_data = Map(
      "a" -> Map("12" -> Seq[Double](0.08, 0.08), "1" -> Seq[Double](0.10, 0.10), "2" -> Seq[Double](0.34, 0.34), "3" -> Seq[Double](0.450, 0.450), "4" -> Seq[Double](0.026, 0.026), "5" -> Seq[Double](0.0267, 0.0267)),
      "b" -> Map("12" -> Seq[Double](0.33, 0.33), "1" -> Seq[Double](0.32, 0.32), "2" -> Seq[Double](0.24, 0.24), "3" -> Seq[Double](0.064, 0.064), "4" -> Seq[Double](0.022, 0.022), "5" -> Seq[Double](0.0064, 0.0064)),
      "c" -> Map("12" -> Seq[Double](0.31, 0.31), "1" -> Seq[Double](0.30, 0.30), "2" -> Seq[Double](0.24, 0.24), "3" -> Seq[Double](0.083, 0.083), "4" -> Seq[Double](0.036, 0.036), "5" -> Seq[Double](0.0166, 0.0166)),
      "d" -> Map("12" -> Seq[Double](0.32, 0.32), "1" -> Seq[Double](0.31, 0.31), "2" -> Seq[Double](0.23, 0.23), "3" -> Seq[Double](0.077, 0.77), "4" -> Seq[Double](0.033, 0.033), "5" -> Seq[Double](0.0101, 0.0101)),
      "e" -> Map("12" -> Seq[Double](0.33, 0.33), "1" -> Seq[Double](0.30, 0.30), "2" -> Seq[Double](0.23, 0.23), "3" -> Seq[Double](0.100, 0.100), "4" -> Seq[Double](0.033, 0.033), "5" -> Seq[Double](0.2838, 0.2838)),
      "f" -> Map("12" -> Seq[Double](0.043, 0.043), "1" -> Seq[Double](0.07, 0.07), "2" -> Seq[Double](0.139, 0.139), "3" -> Seq[Double](0.240, 0.240), "4" -> Seq[Double](0.2, 0.2), "5" -> Seq[Double](0.3433, 0.3433)),
      "g" -> Map("12" -> Seq[Double](0, 0), "1" -> Seq[Double](0.02, 0.02), "2" -> Seq[Double](0.08, 0.08), "3" -> Seq[Double](0.233, 0.233), "4" -> Seq[Double](0.316, 0.316), "5" -> Seq[Double](0.3210, 0.3210)),
      "h" -> Map("12" -> Seq[Double](0.01, 0.01), "1" -> Seq[Double](0.04, 0.04), "2" -> Seq[Double](0.10, 0.10), "3" -> Seq[Double](0.234, 0.234), "4" -> Seq[Double](0.294, 0.294), "5" -> Seq[Double](0.3333, 0.3333)),
      "i" -> Map("12" -> Seq[Double](0, 0), "1" -> Seq[Double](0.03, 0.03), "2" -> Seq[Double](0.10, 0.10), "3" -> Seq[Double](0.233, 0.233), "4" -> Seq[Double](0.300, 0.300), "5" -> Seq[Double](0.3184, 0.3184))
    )
    toy_data
  }
}
