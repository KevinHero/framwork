package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 得到数据库支持的字符串函数的列表
 * 
 * 
 * 
 */
public class DBFunctionString {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到字符串函数的列表
      String[] stringFunctions = dbmd.getStringFunctions().split(",\\s*");
    } catch (SQLException e) {
    }

  }

}
