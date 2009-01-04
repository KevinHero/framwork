package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 检测数据库是否支持可更新的结果集
 * 
 * 
 * 
 */
public class DBResultUpdatableDeterming {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dmd = connection.getMetaData();
      if (dmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
          ResultSet.CONCUR_UPDATABLE)) {
        // 支持
      } else {
        // 不支持
      }
    } catch (SQLException e) {
    }

  }

}
