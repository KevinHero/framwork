package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 放弃更新可更新结果集的行数据
 * 
 *
 * 
 */
public class DBResultSetUpdatableUpdateCancel {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可更新的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 移动到要更新的位置
      resultSet.first();

      // 更新数据
      resultSet.updateString("col_string", "new data");

      // 放弃更新这一行的数据
      resultSet.cancelRowUpdates();
    } catch (SQLException e) {
    }

  }

}
