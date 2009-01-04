package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 检测数据库是否支持可滚动的结果集。
 * 
 *
 * 
 */
public class DBScrollableDetect {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接

    try {
      DatabaseMetaData dmd = connection.getMetaData();
      if (dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
        // 支持不敏感的可滚动的结果集
      }
      if (dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
        // 支持敏感的可滚动的结果集
      }
      if (!dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)
          && !dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
        // 如果都不支持，则不支持可更新的结果集
      }
    } catch (SQLException e) {
    }

  }

}
