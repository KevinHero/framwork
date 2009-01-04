package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作的预取(FetchSize)的设置。
 * 
 * 
 * 
 */
public class FetchSize {

  public static void main(String[] args) {
    Connection connection = null;
    try {
      // 拿到Statement当前的预取数量
      Statement stmt = connection.createStatement();
      int fetchSize = stmt.getFetchSize();

      // 设置其预取数量
      stmt.setFetchSize(100);

      // 创建结果集
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 修改结果集的预取数量
      resultSet.setFetchSize(100);
    } catch (SQLException e) {
    }

  }

}
