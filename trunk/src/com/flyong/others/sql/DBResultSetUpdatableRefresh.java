package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 可更新结果集的当前行数据更新。
 * 
 * 
 * 
 */
public class DBResultSetUpdatableRefresh {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可更新的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 其它的使用结果集的操作

      // 从数据库读取最新的当前行数据
      resultSet.refreshRow();
    } catch (SQLException e) {
    }

  }

}
