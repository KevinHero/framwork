package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 得到数据库支持的系统函数的列表
 * 
 *
 * 
 */
public class DBFunctionSystem {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到系统函数的列表
      String[] systemFunctions = dbmd.getSystemFunctions().split(",\\s*");

    } catch (SQLException e) {
    }

  }

}
