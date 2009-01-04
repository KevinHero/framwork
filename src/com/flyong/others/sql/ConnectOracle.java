package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接Oracle数据库。
 * 
 *
 * 
 */
public class ConnectOracle {

  public static void main(String[] args) {
    Connection connection = null;
    try {
      // 装载驱动
      // 请使用最新的合适的驱动，比如 ojdbc.jar
      // 而不是很古老的 class12.jar
      String driverName = "oracle.jdbc.driver.OracleDriver";
      Class.forName(driverName);

      // 创建数据库链接
      String serverName = "127.0.0.1"; // 主机
      String portNumber = "1521"; // 端口
      String sid = "mydatabase"; // 数据库的SID名字

      // 组合成链接的url
      String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
      String username = "username";
      String password = "password";
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
      // 没有找到驱动
    } catch (SQLException e) {
      // 无法连接数据库
    }

  }

}
