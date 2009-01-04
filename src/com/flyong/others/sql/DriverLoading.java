package com.flyong.others.sql;

/**
 * 装载JDBC驱动。<br>
 * 
 * 
 * 
 */
public class DriverLoading {

  public static void main(String[] args) {
    try {
      // 装载JDBC的驱动
      String driverName = "com.mysql.jdbc.Driver";
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      // 没有找到这个驱动
      // 请确认驱动在你的CLASSPATH 里面
    }
  }
}
