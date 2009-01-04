package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除一个表的所有数据。
 * 
 * 
 * 
 */
public class DBDeleteRowsAll {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();

      // 使用 TRUNCATE,这个速度更快，因为不产生rollback的信息。
      String sql = "TRUNCATE my_table";

      // 使用 DELETE 语句
      sql = "DELETE FROM my_table";

      // 执行删除
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
