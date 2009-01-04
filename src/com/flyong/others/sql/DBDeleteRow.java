package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 删除一行数据。
 * 
 * 
 * 
 */
public class DBDeleteRow {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      Statement stmt = connection.createStatement();

      // DELTE的SQL语句
      String sql = "DELETE FROM my_table WHERE col_string='a string'";

      // 执行删除语句，返回被删除的行数
      int deleteCount = stmt.executeUpdate(sql);

      // 使用PreparedStatement 删除数据
      sql = "DELETE FROM my_table WHERE col_string=?";
      PreparedStatement pstmt = connection.prepareStatement(sql);
      // 设置参数值
      pstmt.setString(1, "a string");
      deleteCount = pstmt.executeUpdate();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

  }

}
