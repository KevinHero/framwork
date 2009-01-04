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
 * 从结果集读取记录数量
 * 
 * 
 * 
 */
public class DBResultSetNumberRows {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建Statament
      Statement stmt = connection.createStatement();
      // 读取COUNT(*)
      ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) FROM my_table");

      // 从结果集得到行数，即使数据库没有记录，一样会返回一个0的查询记录
      resultSet.next();
      int rowcount = resultSet.getInt(1);

    } catch (SQLException e) {
    }

  }

}
