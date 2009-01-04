package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 从结果集读取字段的名字。
 * 
 * 
 */
public class DBResltSetColumnName {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建结果集
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

      // 得到结果集的元数据
      ResultSetMetaData rsmd = rs.getMetaData();
      int numColumns = rsmd.getColumnCount();

      // 得到字段名，编号从1开始
      for (int i = 1; i < numColumns + 1; i++) {
        // 字段名
        String columnName = rsmd.getColumnName(i);

        // 对应的表格名字
        String tableName = rsmd.getTableName(i);
      }
    } catch (SQLException e) {
    }

  }

}
