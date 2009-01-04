package com.flyong.others.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 判断结果集是否可以更新。
 * 
 * 
 * 
 */
public class DBResultSetUpdatableDet {
  public static void main(String[] args) {
    ResultSet resultSet = null; // 从其它地方的结果集
    try {
      // 得到结果集的Concurrency
      int concurrency = resultSet.getConcurrency();

      if (concurrency == ResultSet.CONCUR_UPDATABLE) {
        // 结果集可以更新
      } else {
        // 结果集不可以更新
      }
    } catch (SQLException e) {
    }
  }
}
