package com.flyong.others.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * BLOB字段数据的读取.
 * 
 * 
 * 
 */
public class DBResultSetBlob {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {

      Statement stmt = connection.createStatement();
      // 读取BLOB字段
      ResultSet rs = stmt.executeQuery("SELECT col_blob FROM mysql_all_table");

      if (rs.next()) {
        // 从结果集拿到BLOB
        Blob blob = rs.getBlob("col_blob");

        // 得到BLOB的字节长度
        long blobLength = blob.length();

        // 读取字节数据
        int pos = 1; // 位置从1开始
        int len = 10;
        byte[] bytes = blob.getBytes(pos, len);

        // 使用输入流读取BLOB
        InputStream is = blob.getBinaryStream();
        int b = is.read();
      }
    } catch (IOException e) {
    } catch (SQLException e) {
    }

  }

}
