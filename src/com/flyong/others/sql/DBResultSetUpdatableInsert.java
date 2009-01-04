package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用可更新结果集来插入数据。
 * 
 *
 * 
 */
public class DBResultSetUpdatableInsert {
  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可更新的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 移动到可以插入数据的位置
      resultSet.moveToInsertRow();

      // 设置要插入的数据
      resultSet.updateString("col_string", "new data");

      // 插入数据
      resultSet.insertRow();
    } catch (SQLException e) {
    }

  }

}
