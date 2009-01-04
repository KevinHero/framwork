package com.flyong.others.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 使用PreparedStatement向数据库插入数据。
 * 
 *
 * 
 */
public class DBInsertPreparedStatement {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // INSERT语句
      String sql = "INSERT INTO my_table (col_string) VALUES(?)";
      // 构造PerparedStatement
      PreparedStatement pstmt = connection.prepareStatement(sql);

      // 循环插入10行数据
      for (int i = 0; i < 10; i++) {
        // 设置参数的值
        pstmt.setString(1, "row " + i);

        // 插入数据
        pstmt.executeUpdate();
      }
    } catch (SQLException e) {
    }

    // 演示各种参数的设置方法。
    try {
      // Prepare a statement to insert a record
      String sql = "INSERT INTO mysql_all_table("
        + "col_boolean,"
        + "col_byte,"
        + "col_short,"
        + "col_int,"
        + "col_long,"
        + "col_float,"
        + "col_double,"
        + "col_bigdecimal,"
        + "col_string,"
        + "col_date,"
        + "col_time,"
        + "col_timestamp,"
        + "col_asciistream,"
        + "col_binarystream,"
        + "col_blob) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

      PreparedStatement pstmt = connection.prepareStatement(sql);

      // Set the values
      pstmt.setBoolean(1, true);
      pstmt.setByte(2, (byte) 123);
      pstmt.setShort(3, (short) 123);
      pstmt.setInt(4, 123);
      pstmt.setLong(5, 123L);
      pstmt.setFloat(6, 1.23F);
      pstmt.setDouble(7, 1.23D);
      pstmt.setBigDecimal(8, new BigDecimal(1.23));
      pstmt.setString(9, "a string");
      pstmt.setDate(10, new java.sql.Date(System.currentTimeMillis()));
      pstmt.setTime(11, new Time(System.currentTimeMillis()));
      pstmt.setTimestamp(12, new Timestamp(System.currentTimeMillis()));

      // 设置字符流
      File file = new File("infilename1");
      FileInputStream is = new FileInputStream(file);
      pstmt.setAsciiStream(13, is, (int) file.length());

      // 设置二进制字节流
      file = new File("infilename2");
      is = new FileInputStream(file);
      pstmt.setBinaryStream(14, is, (int) file.length());

      // 设置blob
      file = new File("infilename3");
      is = new FileInputStream(file);
      pstmt.setBinaryStream(15, is, (int) file.length());

      // 插入数据
      pstmt.executeUpdate();
    } catch (SQLException e) {
    } catch (FileNotFoundException e) {
    }

  }

}
