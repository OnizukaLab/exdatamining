name := "udafApp"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.3",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.apache.spark" %% "spark-hive" % "2.2.0"
)

// psql を接続する際に必要
// libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
// libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"
