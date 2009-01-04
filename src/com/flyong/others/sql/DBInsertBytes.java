package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 向数据库插入和读取字节数组的二进制类型数据。
 * 
 * 
 * 
 */
public class DBInsertBytes {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // INSERT语句
      String sql = "INSERT INTO mysql_all_table (col_binarystream) VALUES(?)";
      PreparedStatement pstmt = connection.prepareStatement(sql);

      // 创建二进制数据
      byte[] buffer = "some data".getBytes();

      // 设置数据参数
      pstmt.setBytes(1, buffer);

      // 执行插入数据
      pstmt.executeUpdate();
      pstmt.close();

      // 读取数据记录
      Statement stmt = connection.createStatement();
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM mysql_all_table");
      while (resultSet.next()) {
        // 从二进制列读取数据
        byte[] bytes = resultSet.getBytes("col_binarystream");
      }
    } catch (SQLException e) {
    }

  }

}
