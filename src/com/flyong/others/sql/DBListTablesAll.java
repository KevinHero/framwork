package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 列出数据库的所有表格。
 * 
 * 
 * 
 */
public class DBListTablesAll {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 得到数据库的描述信息
      DatabaseMetaData dbmd = connection.getMetaData();

      // 指定特殊的对象类型，这里我们使用table
      String[] types = { "TABLE" };
      ResultSet resultSet = dbmd.getTables(null, null, "%", types);

      // 循环得到表格的名字
      while (resultSet.next()) {
        // 表格名字
        String tableName = resultSet.getString(3);

        // 表格的 Catalog 和 Schema名字
        String tableCatalog = resultSet.getString(1);
        String tableSchema = resultSet.getString(2);
      }
    } catch (SQLException e) {
    }

  }

}
