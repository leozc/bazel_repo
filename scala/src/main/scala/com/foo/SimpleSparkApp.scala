package com.foo

import org.apache.spark.sql.SparkSession

object SimpleSparkApp {
  def main(args: Array[String]) {
    val logFile = "scala/README.md" // Should be some file on your system
    
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}