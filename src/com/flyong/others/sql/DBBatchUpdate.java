package com.flyong.others.sql;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行批量更新操作。
 * 
 *
 * 
 */
public class DBBatchUpdate {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Connection connection = null; // 从其它地方获取链接
    try {
      // 启动事务
      connection.setAutoCommit(false);

      String sql = "INSERT INTO my_table VALUES(?)";
      PreparedStatement pstmt = connection.prepareStatement(sql);

      // 增加10行数据
      for (int i = 0; i < 10; i++) {
        pstmt.setString(1, "" + i);
        pstmt.addBatch();
      }

      // 执行批量操作
      // 返回每个单独的操作影响的数据行数
      int[] updateCounts = pstmt.executeBatch();

      // 对每一个返回的影响行数进行判断
      processUpdateCounts(updateCounts);

      // 全部成功，提交事务
      connection.commit();
    } catch (BatchUpdateException e) {
      // 如果没有去全部成功，则拿到执行的结果
      int[] updateCounts = e.getUpdateCounts();

      // 对每一个返回的影响行数进行判断
      processUpdateCounts(updateCounts);

      // 这里可以部分提交或者回滚RollBack
      try {
        connection.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } catch (SQLException e) {
    }

  }

  public static void processUpdateCounts(int[] updateCounts) {
    for (int i = 0; i < updateCounts.length; i++) {
      if (updateCounts[i] >= 0) {
        // 成功的。
      } else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
        // 没有成功更新某一行
      } else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
        // 执行失败
      }
    }
  }

}
