package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 得到数据库支持的表格名字最大长度。
 * 
 * 
 * 
 */
public class DBTableNameMaxLength {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到最大的表格名字长度
      int length = dbmd.getMaxTableNameLength();

    } catch (SQLException e) {
    }

  }

}
