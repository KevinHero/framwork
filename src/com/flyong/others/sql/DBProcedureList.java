package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 获取数据库的所有存储过程的名字。
 * 
 *
 * 
 */
public class DBProcedureList {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 得到数据库的描述数据
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到所有的存储过程，包括任何 schema 和 catalog
      ResultSet resultSet = dbmd.getProcedures(null, null, "%");

      // 得到存储过程的名字
      while (resultSet.next()) {
        String procName = resultSet.getString(3);
      }
    } catch (SQLException e) {
    }

  }

}
