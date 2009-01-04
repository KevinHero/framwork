package com.flyong.others.sql;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 从结果集读取数据。
 * 
 * 
 * 
 */
public class DBResultSetRead {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建Statament
      Statement stmt = connection.createStatement();
      // 读取数据到结果集
      ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

      // 循环得到每一行的数据.
      // 注意，结果集的初始化位置在第一个记录的前面，
      // 所以必须先next才能移动到第一个记录
      while (rs.next()) {
        // 根据记录的列的位置(索引)读取数据
        String s1 = rs.getString(1);

        // 根据列的字段名字读取数据
        String s2 = rs.getString("col_string");

        // 不同的数据类对应的读取方法。
        boolean bool = rs.getBoolean("col_boolean");
        byte b = rs.getByte("col_byte");
        short s = rs.getShort("col_short");
        int i = rs.getInt("col_int");
        long l = rs.getLong("col_long");
        float f = rs.getFloat("col_float");
        double d = rs.getDouble("col_double");
        BigDecimal bd = rs.getBigDecimal("col_bigdecimal");
        String str = rs.getString("col_string");
        Date date = rs.getDate("col_date");
        Time t = rs.getTime("col_time");
        Timestamp ts = rs.getTimestamp("col_timestamp");
        InputStream ais = rs.getAsciiStream("col_asciistream");
        InputStream bis = rs.getBinaryStream("col_binarystream");
        Blob blob = rs.getBlob("col_blob");

      }
    } catch (SQLException e) {
    }

  }

}
