package udafApp


  udaf to calculate sum of value
 ------------------------------*/
class MergeValue extends UserDefinedAggregateFunction {
  // This is the input fields for your aggregate function.
  override def inputSchema: org.apache.spark.sql.types.StructType = StructType(
    StructField("value", DoubleType) :: Nil
  )

  // This is the internal fields you keep for computing your aggregate.
  override def bufferSchema: StructType = StructType(
    StructField("value", DoubleType) :: Nil
  )

  // This is the output type of your aggregatation function.
  override def dataType: DataType = DoubleType

  override def deterministic: Boolean = true

  // This is the initial value for your buffer schema.
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0.0
  }

  // This is how to update your buffer schema given an input.
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getAs[Double](0) + input.getAs[Double](0)
  }

  // This is how to merge two objects with the bufferSchema type.
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getAs[Double](0) + buffer2.getAs[Double](0)
  }

  // This is where you output the final value, given the final value of your bufferSchema.
  override def evaluate(buffer: Row): Any = {
    buffer.getDouble(0)
  }
}

/*------------------------------
  udaf to calculate variance to merge twp group
 ------------------------------*/
class MergeVariance extends UserDefinedAggregateFunction {
  // This is the input fields for your aggregate function.
  override def inputSchema: org.apache.spark.sql.types.StructType = StructType(
    StructField("count", LongType) ::
      StructField("average", DoubleType) ::
      StructField("variance", DoubleType) ::
      Nil
  )

  // This is the internal fields you keep for computing your aggregate.
  override def bufferSchema: StructType = StructType(
    StructField("count", LongType) ::
      StructField("average", DoubleType) ::
      StructField("variance", DoubleType) :: Nil
  )

  // This is the output type of your aggregatation function.
  override def dataType: DataType = DoubleType

  override def deterministic: Boolean = true

  // This is the initial value for your buffer schema.
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0.0
    buffer(2) = 0.0
  }

  // This is how to update your buffer schema given an input.
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(2) =
      (
        buffer.getAs[Long](0) *
          (buffer.getAs[Double](2) + math.pow(buffer.getAs[Double](1), 2.0))
          +
          input.getAs[Long](0) *
            (input.getAs[Double](2) + math.pow(input.getAs[Double](1), 2.0))
        ) /
        (buffer.getAs[Long](0) + input.getAs[Long](0))
    buffer(1) =
      (
        buffer.getAs[Double](1) * buffer.getAs[Long](0) +
          input.getAs[Long](0) * input.getAs[Double](1)
        ) /
        (
          buffer.getAs[Long](0) + input.getAs[Long](0)
          )
    buffer(0) = buffer.getAs[Long](0) + input.getAs[Long](0)
    buffer(2) = buffer.getAs[Double](2) - math.pow(buffer.getAs[Double](1), 2.0)
  }

  // This is how to merge two objects with the bufferSchema type.
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(2) = (buffer1.getAs[Long](0) * (buffer1.getAs[Double](2) + math.pow(buffer1.getAs[Double](1), 2.0)) + buffer2.getAs[Long](0) * (buffer2.getAs[Double](2) + math.pow(buffer2.getAs[Double](1), 2.0))) / (buffer1.getAs[Long](0) + buffer2.getAs[Long](0))
    buffer1(1) = (buffer1.getAs[Double](1) * buffer1.getAs[Long](0) + buffer2.getAs[Long](0) * buffer2.getAs[Double](1)) / (buffer1.getAs[Long](0) + buffer2.getAs[Long](0))
    buffer1(0) = buffer1.getAs[Long](0) + buffer2.getAs[Long](0)
    buffer1(2) = buffer1.getAs[Double](2) - math.pow(buffer1.getAs[Double](1), 2.0)
  }

  // This is where you output the final value, given the final value of your bufferSchema.
  override def evaluate(buffer: Row): Any = {
    buffer.getDouble(2)
  }
}


/*------------------------------
  udaf to calculate distance between two points
 ------------------------------*/
class CalcuDistance extends UserDefinedAggregateFunction {
  // This is the input fields for your aggregate function.
  override def inputSchema: org.apache.spark.sql.types.StructType = StructType(
    StructField("axis_1", DoubleType) ::
      StructField("axis_2", DoubleType) ::
      StructField("object_id", LongType) ::
      StructField("target_axis_1", DoubleType) ::
      StructField("target_axis_2", DoubleType) ::
      Nil
  )

  // This is the internal fields you keep for computing your aggregate.
  override def bufferSchema: StructType = StructType(
    StructField(
      "cube",
      DataTypes.createMapType(LongType, DoubleType)
    ) :: Nil
  )

  // This is the output type of your aggregatation function.
  override def dataType: DataType = StructType(
    StructField(
      "nearlest_point", DataTypes.createArrayType(LongType)) ::
      StructField("lrd", DoubleType) :: Nil
  )

  //override def dataType: DataType = new StructType().add("nearlest_point", ArrayType(LongType)).add("lrd", DoubleType)

  override def deterministic: Boolean = true

  // This is the initial value for your buffer schema.
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = Map.empty[Long, Array[Double]]
  }

  // This is how to update your buffer schema given an input.
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getMap(0) ++ Map(
      input.getLong(2) -> math.sqrt(math.pow(input.getDouble(0) - input.getDouble(3), 2.0) + math.pow(input.getDouble(1) - input.getDouble(4), 2.0))
    )
  }

  // This is how to merge two objects with the bufferSchema type.
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getMap(0) ++ buffer2.getMap(0)
    buffer1.getMap(0)
  }

  // This is where you output the final value, given the final value of your bufferSchema.
  override def evaluate(buffer: Row): Any = {
    val t: Double = buffer.getMap[Long, Double](0).values.toArray.sortWith(_ < _).apply(9)
    val lrd = 10.0 / buffer.getMap[Long, Double](0).filter(f => f._2.toString.toDouble <= t).values.sum
    val n_point: Array[Long] = buffer.getMap[Long, Double](0).filter(f => f._2.toString.toDouble <= t).keys.toArray

    (n_point, lrd)
  }
}

/*------------------------------
  udaf to calculate distance between two points
 ------------------------------*/
class TestCalcuDistance extends UserDefinedAggregateFunction {
  // This is the input fields for your aggregate function.
  override def inputSchema: org.apache.spark.sql.types.StructType = StructType(
    StructField("axis_1", DoubleType) ::
      StructField("axis_2", DoubleType) ::
      StructField("object_id", LongType) ::
      StructField("target_axis_1", DoubleType) ::
      StructField("target_axis_2", DoubleType) ::
      Nil
  )

  // This is the internal fields you keep for computing your aggregate.
  override def bufferSchema: StructType = StructType(
    StructField(
      "cube",
      DataTypes.createMapType(LongType, DoubleType)
    ) :: Nil
  )

  // This is the output type of your aggregatation function.
  override def dataType: DataType = MapType(LongType, DoubleType)

  //override def dataType: DataType = new StructType().add("nearlest_point", ArrayType(LongType)).add("lrd", DoubleType)

  override def deterministic: Boolean = true

  // This is the initial value for your buffer schema.
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = Map.empty[Long, Array[Double]]
  }

  // This is how to update your buffer schema given an input.
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getMap(0) ++ Map(
      input.getLong(2) -> math.sqrt(
        math.pow(input.getDouble(0) - input.getDouble(3), 2.0) + math.pow(input.getDouble(1) - input.getDouble(4), 2.0))
    )
  }

  // This is how to merge two objects with the bufferSchema type.
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getMap(0) ++ buffer2.getMap(0)
    buffer1.getMap(0)
  }

  // This is where you output the final value, given the final value of your bufferSchema.
  override def evaluate(buffer: Row): Any = {
    buffer.getMap[Long, Double](0)
  }
}
