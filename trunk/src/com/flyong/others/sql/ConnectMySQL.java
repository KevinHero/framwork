package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接MySQL数据库。
 * 
 *
 * 
 */
public class ConnectMySQL {

  public static void main(String[] args) {
    Connection connection = null;
    try {
      // 装载驱动
      String driverName = "com.mysql.jdbc.Driver";
      Class.forName(driverName);

      // 创建数据库连接
      String serverName = "localhost";
      String mydatabase = "mydatabase";
      String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC
      // url
      String username = "username";
      String password = "password";
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
      // 没找到驱动
    } catch (SQLException e) {
      // 无法连接数据库
    }

  }

}
