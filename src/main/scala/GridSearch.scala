package udafApp

import org.apache.spark.sql.{DataFrame, SQLContext}

object GridSearch {

  def getMaxMinCoord(sqlContext: SQLContext, axis_str: String): Unit ={
    sqlContext.sql("")
  }

  def makeGrid(): Unit ={

  }


  def test(sqlContext: SQLContext, df: DataFrame): Unit ={
    //import sqlContext.implicits._
    df.createOrReplaceTempView("grid_test")

    sqlContext.sql("select max(x), min(x), max(y), min(y) from grid_test").show()
    df.agg("x" -> "min").show()
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

  def sample(): Unit ={
    println("====================================================================")
    val grid = (1 to 250000).map { _ => Coord(Math.random * 5, Math.random * 5) }
    val x = Coord(Math.random * 5, Math.random * 5)

    println(top(grid, 3)(new CoordOrdering(x)))

  }
}
