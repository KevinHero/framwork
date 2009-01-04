package com.flyong.others.sql;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 获取数据库驱动的所有属性的情况。
 * 
 * 
 * 
 */
public class DriverPropertyList {

  public static void main(String[] args) {
    try {
      // 装载驱动
      String driverName = "com.mysql.jdbc.Driver";
      Class.forName(driverName);

      // 得到一个实例
      String url = "jdbc:mysql://127.0.0.1/mysqldb";
      Driver driver = DriverManager.getDriver(url);

      // 获取所有可用的属性
      DriverPropertyInfo[] info = driver.getPropertyInfo(url, null);
      for (int i = 0; i < info.length; i++) {
        // 名字
        String name = info[i].name;
        System.out.println("name=" + name);

        // 是否必须
        boolean isRequired = info[i].required;
        System.out.println("isRequired=" + isRequired);

        // 当前值
        String value = info[i].value;
        System.out.println("value=" + value);

        // 属性的描述
        String desc = info[i].description;
        System.out.println("desc=" + desc);

        // 拿到属性值可用的选择项，如果为null,则可以是任何字符串
        String[] choices = info[i].choices;
        System.out.println("choices=" + Arrays.toString(choices));
        System.out.println("-----------------------------------------");
      }
    } catch (ClassNotFoundException e) {
      // 没找到驱动

    } catch (SQLException e) {
      // 无法连接数据库

    }

  }

}
