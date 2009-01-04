package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用可更新的结果集更新数据。
 * 
 * 
 * 
 */
public class DBResultSetUpdatableUpdate {

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

      // 更新行数据;如果 auto-commit 是true,则commit数据
      resultSet.updateRow();
    } catch (SQLException e) {
    }

  }

}
