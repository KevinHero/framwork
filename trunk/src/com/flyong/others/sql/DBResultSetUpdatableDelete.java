package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用可更新的结果集删除数据。
 * 
 *
 * 
 */
public class DBResultSetUpdatableDelete {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建可更新的结果集
      Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");

      // 移动到要删除的行
      resultSet.first();

      // 删除当前行
      resultSet.deleteRow();
    } catch (SQLException e) {
    }

  }

}
