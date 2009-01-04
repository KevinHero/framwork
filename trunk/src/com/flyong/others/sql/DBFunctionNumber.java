package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 得到数据库支持的数值函数的列表
 * 
 * 
 * 
 */
public class DBFunctionNumber {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到数值函数的列表
      String[] numericFunctions = dbmd.getNumericFunctions().split(",\\s*");
    } catch (SQLException e) {
    }

  }

}
