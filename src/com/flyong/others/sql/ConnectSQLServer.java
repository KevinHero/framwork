package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接Microsoft SQL Server 数据库
 * 
 * 
 * 
 */
public class ConnectSQLServer {

  /**
   * JDBC 3.0的连接方式。<br>
   * 其驱动为一个 sqljdbc.jar.
   * 
   * @return
   */
  public static Connection getJDBC3_0() {
    try {
      String host = "localhost"; // 主机
      int port = 1433; // 端口
      String username = "guest";
      String password = "guest";

      String connectionUrl = "jdbc:sqlserver://" + host + ":" + port + ";"
          + "databaseName=AdventureWorks;user=" + username + ";password=" + password;
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      return DriverManager.getConnection(connectionUrl);
    } catch (ClassNotFoundException e) {
      // 没找到驱动
      return null;
    } catch (SQLException e) {
      // 无法连接数据库
      return null;
    }
  }

  /**
   * JDBC2.0 的连接方式。<br>
   * 其驱动为三个 jar的那个
   * 
   * @return
   */
  public static Connection getJDBC2_0() {
    try {
      String host = "localhost"; // 主机
      int port = 1433; // 端口
      String username = "guest";
      String password = "guest";

      String connectionUrl = "jdbc:microsoft:sqlserver://" + host + ":" + port + ";"
          + "databaseName=AdventureWorks;user=" + username + ";password=" + password;
      Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
      return DriverManager.getConnection(connectionUrl);
    } catch (ClassNotFoundException e) {
      // 没找到驱动
      return null;
    } catch (SQLException e) {
      // 无法连接数据库
      return null;
    }
  }
}
