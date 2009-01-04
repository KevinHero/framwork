package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 检测数据库是否支持事务。
 * 
 *
 * 
 */
public class DriverSupportTransaction {

  public boolean isSupportTransaction(Connection connection) {
    try {
      // 用数据库连接的元数据。
      DatabaseMetaData dmd = connection.getMetaData();
      if (dmd.supportsTransactions()) {
        // 支持事务
        return true;
      } else {
        // 不支持
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

  }
}
