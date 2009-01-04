package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 得到所有非SQL92关键字的列表
 * 
 * 
 * 
 */
public class DBKeywordList {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到所有非SQL92关键字的列表，是逗号分隔的。
      String[] keywords = dbmd.getSQLKeywords().split(",\\s*");
    } catch (SQLException e) {
    }

  }

}
