package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 检测数据库是否支持批量更新。
 * 
 * 
 * 
 */
public class DBSupportBatchUpdates {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dmd = connection.getMetaData();
      // 检测是否支持批量更新
      if (dmd.supportsBatchUpdates()) {
        // 支持
      } else {
        // 不支持
      }
    } catch (SQLException e) {
    }

  }

}
