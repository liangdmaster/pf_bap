package conf

import java.util.Properties

/**
  * SQL管理组件
  * 提供key对应的SQL语句
  */
object SQLManager {
  private val prop = new Properties()

  try {
    // 通过调用类加载器（ClassLoader）的getResourceAsStream方法获取指定文件的输入流
    val in = SQLManager.getClass.getClassLoader.getResourceAsStream("sql.properties")
    prop.load(in)
  } catch {
    case e: Exception => e.printStackTrace()
  }

  /**
    * 获取指定key对应的value
    *
    * @param key
    * @return
    */
  def getProperty(key: String): String = {
    prop.getProperty(key)
  }

  /**
    * 获取布尔类型的配置项
    *
    * @param key
    * @return
    */
  def getBoolean(key: String): Boolean = {
    val value: java.lang.String = getProperty(key)
    try {
//      Boolean.unbox(value) // 抛异常
      return java.lang.Boolean.valueOf(value)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    false
  }

}
