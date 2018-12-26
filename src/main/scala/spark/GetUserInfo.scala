package src.main.scala.spark

import conf.SQLManager
import constant.Constants
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import utils.SparkUtils

object GetUserInfo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName(Constants.SPARK_APP_NAME_USER)
    SparkUtils.setMaster(conf)
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)

    // 加载相应的sql语句，
    // args(0)为要加载的表名
    // args(1)为日期条件
    val sql = SQLManager.getProperty(args(0)).replace("?", args(1))

    sqlContext.sql(sql)

  }
}
