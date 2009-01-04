package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 可移动结果集的移动操作。
 * 
 * 
 * 
 */
public class DBResultScrollableMove {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可移动的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 向前移动指针
      while (resultSet.next()) {
        // 得到当前位置的数据
        String s = resultSet.getString(1);
      }

      // 向后移动指针
      while (resultSet.previous()) {
        // 得到数据
        String s = resultSet.getString(1);
      }

      // 移动到第一行
      resultSet.first();

      // 移动到最后一个
      resultSet.last();

      // 移动到最后一个后面，再next将返回false;
      resultSet.afterLast();

      // 移动到第一行的前面，需要使用next后才能读取。等于位置0
      resultSet.beforeFirst();

      // 移动数据到第二行
      resultSet.absolute(2);

      // 移动到上一行
      resultSet.absolute(-1);

      // 移动到上2行
      resultSet.absolute(-2);

      // 向前移动5行。如果超了最后一行，则在最后一行上。
      resultSet.relative(5);

      // Move cursor up 3 rows from the current row. If this moves
      // cursor beyond the first row, cursor is put before the first row
      resultSet.relative(-3);
      // 向后移动3行。如果超过了第一行，则在第一行上。
    } catch (SQLException e) {
    }

  }

}
