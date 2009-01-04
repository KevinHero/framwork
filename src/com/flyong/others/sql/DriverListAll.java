package com.flyong.others.sql;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

/**
 * 列出当前装载的所有驱动。
 * 
 * 
 * 
 */
public class DriverListAll {

  public static void main(String[] args) throws Exception {
    // 装载JDBC的驱动
    String driverName = "com.mysql.jdbc.Driver";
    Class.forName(driverName);

    List<Driver> drivers = Collections.list(DriverManager.getDrivers());
    for (Driver driver : drivers) {

      // 驱动的名字
      String name = driver.getClass().getName();
      System.out.println("name=" + name);

      // 版本信息
      int majorVersion = driver.getMajorVersion();
      System.out.println("majorVersion=" + majorVersion);
      int minorVersion = driver.getMinorVersion();
      System.out.println("minorVersion=" + minorVersion);
      // 报告此驱动程序是否是一个真正的JDBC CompliantTM 驱动程序
      boolean isJdbcCompliant = driver.jdbcCompliant();
      System.out.println("isJdbcCompliant=" + isJdbcCompliant);
    }

  }

}
