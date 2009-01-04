package com.flyong.others.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 调用存储过程。
 * 
 * 
 * 
 */
public class DBProcedureCall {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    CallableStatement cs;
    try {
      // 调用没有任何参数的存储过程
      cs = connection.prepareCall("{call myproc}");
      cs.execute();

      // 一个带有输入参数的存储过程
      cs = connection.prepareCall("{call myprocin(?)}");

      // 设置输入参数
      cs.setString(1, "a string");

      // 执行
      cs.execute();

      // 调用带有输出参数的存储过程
      cs = connection.prepareCall("{call myprocout(?)}");

      // 注册输出参数
      cs.registerOutParameter(1, Types.VARCHAR);

      // 执行，获取输出的值
      cs.execute();
      String outParam = cs.getString(1);

      // 调用带有输入和输出的存储过程
      cs = connection.prepareCall("{call myprocinout(?)}");

      // 注册参数
      cs.registerOutParameter(1, Types.VARCHAR);

      // 设置参数
      cs.setString(1, "a string");

      // 执行并获取结果
      cs.execute();
      outParam = cs.getString(1);
    } catch (SQLException e) {
    }

  }

}
