package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC的事务，提交与回滚。
 * 
 *
 * 
 */
public class DatabaseTransacton {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取连接
    try {
      // 启动事务
      connection.setAutoCommit(false);

      // SQL操作

      // 提交事务
      connection.commit();
    } catch (SQLException e) {
      // 回滚事务
      try {
        connection.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }

  }

}
