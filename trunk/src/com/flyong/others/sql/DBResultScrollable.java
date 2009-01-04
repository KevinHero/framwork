package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建可移动的结果集。
 * 
 * 
 * 
 */
public class DBResultScrollable {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建不敏感的可移动的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);

      // 创建敏感的可移动的结果集
      stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
    } catch (SQLException e) {
    }

  }

}
