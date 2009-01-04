package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 模糊查询的使用。
 * 
 * 
 * 
 */
public class DBQueryWildcards {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建 statement
      Statement stmt = connection.createStatement();

      // 读取包含这个字符串的数据记录
      String sql = "SELECT * FROM my_table WHERE col_string LIKE '%pat%'";

      // 读取以这个字符串结尾的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE '%pat'";

      // 读取以这个字符串开头的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE 'pat%'";

      // 读取以abc开头，以xyz结尾的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE 'abc%xyz'";

      // 转义。读取字段为pat%的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE 'pat\\%'";

      // 读取p开头，t结尾的长度为3的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE 'p_t'";

      // 转义，读取字段为p_t的数据记录
      sql = "SELECT * FROM my_table WHERE col_string LIKE 'p\\_t'";

      // 执行查询
      ResultSet resultSet = stmt.executeQuery(sql);
    } catch (SQLException e) {
    }

  }

}
