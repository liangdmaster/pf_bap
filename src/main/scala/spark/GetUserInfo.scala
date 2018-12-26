package src.main.scala.spark

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object GetUserInfo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("GetUserInfo")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)








  }
}
