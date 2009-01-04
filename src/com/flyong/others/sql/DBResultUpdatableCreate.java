package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建一个返回可更新结果集
 * 
 * 
 * 
 */
public class DBResultUpdatableCreate {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建Statement
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);

      // 必须指定主键
      ResultSet resultSet = stmt.executeQuery("SELECT col_string FROM my_table");
    } catch (SQLException e) {
    }

  }

}
