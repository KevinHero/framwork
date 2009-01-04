package com.flyong.others.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 调用数据库的函数
 * 
 * 
 * 
 */
public class DBFunctionCall {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    CallableStatement cs;
    try {
      // 调用无参数的函数，这个函数返回一个VARCHAR类型
      cs = connection.prepareCall("{? = call myfunc}");

      // 注册返回类型
      cs.registerOutParameter(1, Types.VARCHAR);

      // 执行并获取结果
      cs.execute();
      String retValue = cs.getString(1);

      // 调用一个带有输入参数的函数。函数返回VARCHAR类型
      cs = connection.prepareCall("{? = call myfuncin(?)}");

      // 注册返回的类型
      cs.registerOutParameter(1, Types.VARCHAR);

      // 设置输入参数
      cs.setString(2, "a string");

      // 执行并获取结果
      cs.execute();
      retValue = cs.getString(1);

      // 调用带有输出参数的函数，函数返回类型为 VARCHAR
      cs = connection.prepareCall("{? = call myfuncout(?)}");

      // 注册返回参数类型和输出的参数类型
      cs.registerOutParameter(1, Types.VARCHAR);
      cs.registerOutParameter(2, Types.VARCHAR);

      // 执行并获取结果
      cs.execute();
      retValue = cs.getString(1); // 返回值
      String outParam = cs.getString(2); // 输出参数

      // 带有输入/输出参数的函数，返回类型为VARCHAR
      cs = connection.prepareCall("{? = call myfuncinout(?)}");

      // 注册返回值的类型和输出参数类型
      cs.registerOutParameter(1, Types.VARCHAR);
      cs.registerOutParameter(2, Types.VARCHAR);

      // 设置输入输出的参数
      cs.setString(2, "a string");

      // 执行并获取结果
      cs.execute();
      retValue = cs.getString(1); // 返回值
      outParam = cs.getString(2); // 输入输出参数
    } catch (SQLException e) {
    }

  }

}
