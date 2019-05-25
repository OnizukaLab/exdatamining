package udafApp

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

class ExperimentEngine extends UserDefinedAggregateFunction {
  // This is the input fields for your aggregate function.
  override def inputSchema: org.apache.spark.sql.types.StructType =
    new StructType().add("subsetdata", DataTypes.StringType).add("x_value", DataTypes.StringType).add("y_value", DataTypes.DoubleType)

  // This is the internal fields you keep for computing your aggregate.
  // [ subsetdata -> [x_value -> y_value(SUM, COUNT)] ]
  override def bufferSchema: StructType = StructType(
    StructField("cube", DataTypes.createMapType(
      StringType, DataTypes.createMapType(StringType, DataTypes.createArrayType(DoubleType))
    )) :: Nil)

  // This is the output type of your aggregatation function.
  override def dataType: DataType = MapType(StringType, MapType(StringType, DataTypes.createArrayType(DoubleType)))

  override def deterministic: Boolean = true

  // This is the initial value for your buffer schema.
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = Map[String, Map[String, Seq[Double]]]("All" -> Map[String, Seq[Double]]())
    //buffer(1) = 0D
  }

  // This is how to update your buffer schema given an input.
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    val cube = buffer.getAs[Map[String, Map[String, Seq[DoubleType]]]](0)

    //For to update value of subsetdata
    val subset = cube.getOrElse(input.getAs[String](0), Map())
    val subset_array = subset.getOrElse(input.getAs[String](1), Seq(0D, 0D, 0D))
    val subset_count: Double = subset_array.head.toString.toDouble + 1D
    val subset_avg: Double = (subset_array.head.toString.toDouble * subset_array(1).toString.toDouble + input.getAs[Double](2)) / (subset_array.head.toString.toDouble + 1D)
    val subset_var: Double = ((subset_array(2).toString.toDouble + subset_array(1).toString.toDouble * subset_array(1).toString.toDouble) * subset_array.head.toString.toDouble + input.getAs[Double](2) * input.getAs[Double](2)) / subset_count - subset_avg * subset_avg
    //For to update value of All
    val all = cube.getOrElse("All", Map())
    val sum_array = all.getOrElse(input.getAs[String](1), Seq(0D, 0D, 0D))
    val sum_count: Double = sum_array.head.toString.toDouble + 1D
    val sum_avg: Double = (sum_array.head.toString.toDouble * sum_array(1).toString.toDouble + input.getAs[Double](2)) / (sum_array.head.toString.toDouble + 1D)
    val sum_var: Double = ((sum_array(2).toString.toDouble + sum_array(1).toString.toDouble * sum_array(1).toString.toDouble) * sum_array.head.toString.toDouble + input.getAs[Double](2) * input.getAs[Double](2)) / sum_count - sum_avg * sum_avg

    //Update cube value
    buffer(0) = cube ++
      Map(input.getAs[String](0) -> (subset ++
        Map(input.getAs[String](1) ->
          Seq(subset_count, subset_avg, subset_var)))) ++
      Map("All" -> (all ++
        Map(input.getAs[String](1) ->
          Seq(sum_count, sum_avg, sum_var))))
  }

  // This is how to merge two objects with the bufferSchema type.
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    val map0 = buffer1.getAs[Map[String, Map[String, Seq[Double]]]](0)

    buffer1(0) = map0 ++ buffer2.getAs[Map[String, Map[String, Seq[Double]]]](0).map { case (k, mmap) =>
      val m1 = map0.getOrElse(k, Map())
      val merged = m1 ++ mmap.map { case (kk, v_list) =>
        val ss = m1.getOrElse(kk, Seq(0D, 0D, 0D))
        val count = ss.head + v_list.head
        val average = (ss.head * ss(1) + v_list.head * v_list(1)) / count.toDouble
        val variance = (ss.head * (ss(2) + ss(1) * ss(1)) + v_list.head * (v_list(2) + v_list(1) * v_list(1))) / count - average * average
        kk -> Seq(count, average, variance)
      }
      k -> merged
    }
  }

  // This is where you output the final value, given the final value of your bufferSchema.
  override def evaluate(buffer: Row): Any = {
    buffer.getAs[Map[String, Map[String, Seq[Double]]]](0)
  }
}
