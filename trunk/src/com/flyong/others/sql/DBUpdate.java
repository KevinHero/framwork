package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * executeUpdate更新数据。
 * 
 *
 * 
 */
public class DBUpdate {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();

      // 更新的SQL
      String sql = "UPDATE my_table SET col_string='a new string' WHERE col_string = 'a string'";

      // 执行语句，返回受影响的行数
      int updateCount = stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
