package uadfApp

import org.apache.spark.SparkContext

object uadfApp {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local", "rdd-example")

    val rdd = sc.makeRDD(Seq(Person("hoge", 20)))
    rdd.foreach(println)

    sc.stop()
  }
}
case class Person(name: String, age: Long)

