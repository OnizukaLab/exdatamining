package udafApp

import org.apache.spark.sql.{DataFrame, SQLContext}

case class GridInfo(
                     axis_array: Array[List[Double]],
                     ppd: Int
                   )

object GridSearch {

  var GRI = 1

  def getMaxMinCoord(sqlContext: SQLContext, df: DataFrame, axis_str: String): (Double, Double) = {
    import sqlContext.implicits._
    df.select(axis_str).map { v => (v(0).toString.toDouble, v(0).toString.toDouble) }.reduce { (l, r) =>
      val max_v: Double = math.max(l._1, r._1)
      val min_v: Double = math.min(l._2, r._2)
      (max_v, min_v)
    }
  }

  def makeGrid(maxmin_list: List[(Double, Double)], axis_list: List[String]): Array[Array[Double]] = {
    val ppd = 4 // partition num
    val grid_array = (0 until axis_list.length).map { i =>
      (0 to ppd).map(g => (maxmin_list(i)._1 - maxmin_list(i)._2) / ppd * g + maxmin_list(i)._2).toArray
    }.toArray

    grid_array
  }

  def IndexGrid(sqlContext: SQLContext, df: DataFrame, grid_array: Array[Array[Double]]): DataFrame ={
    import sqlContext.implicits._
    df.join(
      df.rdd.map{ row => 
        (row(0).toString, (1 until row.length).map{ i => grid_array(i-1).lastIndexWhere(n => row(i).toString.toDouble >= n) })
      }.toDF("object_id", "grid_index"),
      "object_id"
    )
  }

  def searchGridIndex(coord: Array[Double], grid_array: Array[Array[Double]]): Unit = {
    println(1)
  }

  def test(sqlContext: SQLContext, df: DataFrame): Unit = {
    //import sqlContext.implicits._
    val axis_list = List("x", "y")

    val axis_range_list = makeGrid(
      axis_list.map{ ax =>
        getMaxMinCoord(sqlContext, df, ax)
      }, 
      axis_list
    )

    val grid_df = IndexGrid(sqlContext, df, axis_range_list)

    

  }


  case class Coord(x: Double, y: Double) {
    def dist(c: Coord) = Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2))
  }

  class CoordOrdering(x: Coord) extends Ordering[Coord] {
    def compare(a: Coord, b: Coord) = a.dist(x) compare b.dist(x)
  }

  def top[T](xs: Seq[T], n: Int)(implicit ord: Ordering[T]): Seq[T] = {
    // xs is an ordered sequence of n elements. insert returns xs with e inserted
    // if it is less than anything currently in the sequence (and in that case,
    // the last element is dropped) otherwise returns an unmodifed sequence

    def insert[T](xs: Seq[T], e: T)(implicit ord: Ordering[T]): Seq[T] = {
      val (l, r) = xs.span(x => ord.lt(x, e))
      (l ++ (e +: r)).take(n)
    }

    xs.drop(n).foldLeft(xs.take(n).sorted)(insert)
  }

  def sample(): Unit = {
    println("====================================================================")
    val grid = (1 to 250000).map { _ => Coord(Math.random * 5, Math.random * 5) }
    val x = Coord(Math.random * 5, Math.random * 5)

    println(top(grid, 3)(new CoordOrdering(x)))
  }
}
