package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 检测是否有数据。
 * 
 *
 * 
 */
public class DBQueryHasValue {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      Connection connection = null; // 从其它地方获取链接
      // 创建一个Statement
      Statement stmt = connection.createStatement();
      // 从表格里读取所有的数据到ResultSet里面
      ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");
      
      // 使用next()检测，如果没有结果数据，则返回false
      if(rs.next()){
        // 存在数据
      }else{
        // 没有数据
      }
    } catch (SQLException e) {
    }

  }

}
