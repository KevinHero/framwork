package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用Statement删除表格
 * 
 * 
 * 
 */
public class DBDeleteTable {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("DROP TABLE my_table");
    } catch (SQLException e) {
    }

  }

}
