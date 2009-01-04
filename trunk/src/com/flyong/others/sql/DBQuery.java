package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 从数据库读取数据。<br>
 * 数据库使用SELECT进行查询，结果保存在ResultSet结果集里面。
 * 
 *
 * 
 */
public class DBQuery {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      Connection connection = null; // 从其它地方获取链接
      // 创建一个Statement
      Statement stmt = connection.createStatement();
      // 从表格里读取所有的数据到ResultSet里面
      ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");
    } catch (SQLException e) {
    }

  }

}
