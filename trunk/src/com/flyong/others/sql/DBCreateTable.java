package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用Statement创建表格
 * 
 * 
 * 
 */
public class DBCreateTable {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();

      // 创建一个名字为 my_table的表格
      String sql = "CREATE TABLE my_table(col_string VARCHAR(254))";

      stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
