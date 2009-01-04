package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 获取可移动结果集的指针位置。
 * 
 * 
 * 
 */
public class DBResultScroolablePosition {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可移动结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 得到当前的指针位置
      int pos = resultSet.getRow(); // 0
      // 是否为第一个结果之前
      boolean b = resultSet.isBeforeFirst(); // true

      // 移动到第一行
      resultSet.next();

      // 得到指针位置
      pos = resultSet.getRow(); // 1
      // 是否为第一个数据
      b = resultSet.isFirst(); // true

      // 移动到最后一行
      resultSet.last();

      // 得到当前的指针位置，如果一共是10行，则返回10
      pos = resultSet.getRow();
      // 是否为最后一个数据
      b = resultSet.isLast(); // true

      // 移动到最后一行后面
      resultSet.afterLast();

      // 得到指针位置，如果一共10个数据，则返回11
      pos = resultSet.getRow();
      // 是否为最后一个后面
      b = resultSet.isAfterLast(); // true
    } catch (SQLException e) {
    }

  }

}
