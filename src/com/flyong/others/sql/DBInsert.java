package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 向数据库插入数据。
 * 
 * 
 * 
 */
public class DBInsert {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();

      // INSERT的SQl语句
      String sql = "INSERT INTO my_table (col_string) VALUES('a string')";

      // 执行,返回成功插入的行数。如果等于0则插入失败。
      int line = stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
