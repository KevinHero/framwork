package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建存储过程和函数(Oracle)
 *
 *
 */
public class DBProcedureFunctionCreate {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      // 创建Statement
      Statement stmt = connection.createStatement();
  
      // 创建没有参数的存储过程
      String procedure =
          "CREATE OR REPLACE PROCEDURE myproc IS "
          + "BEGIN "
          + "INSERT INTO oracle_table VALUES('string 1'); "
          + "END;";
      stmt.executeUpdate(procedure);
  
      // 创建带有输入参数(x)的存储过程
      // 输入IN 是参数的默认模式，所以 x VARCHAR 和 X IN VARCHAR都是允许的
      procedure =
          "CREATE OR REPLACE PROCEDURE myprocin(x VARCHAR) IS "
          + "BEGIN "
          + "INSERT INTO oracle_table VALUES(x); "
          + "END;";
      stmt.executeUpdate(procedure);
  

      // 创建带有输出参数的存储过程
      procedure =
          "CREATE OR REPLACE PROCEDURE myprocout(x OUT VARCHAR) IS "
          + "BEGIN "
          + "INSERT INTO oracle_table VALUES('string 2'); "
          + "x := 'outvalue'; " // 赋值 x
          + "END;";
      stmt.executeUpdate(procedure);
  
      // 创建带有输入/输出参数的存储过程
      // x 作为输入参数，同时也是输出参数
      procedure =
          "CREATE OR REPLACE PROCEDURE myprocinout(x IN OUT VARCHAR) IS "
          + "BEGIN "
          + "INSERT INTO oracle_table VALUES(x); " // Use x as IN parameter
          + "x := 'outvalue'; "                    // Use x as OUT parameter
          + "END;";
      stmt.executeUpdate(procedure);
  

      // 创建一个名字为 myfunc的函数，返回一个 VARCHAR数值，没有参数
      String function =
          "CREATE OR REPLACE FUNCTION myfunc RETURN VARCHAR IS "
          + "BEGIN "
          + "RETURN 'a returned string'; "
          + "END;";
      stmt.executeUpdate(function);
  

      // 创建名字为myfuncin的函数，返回VARCHAR类型
      // 带一个名字为 x 的输入参数
      function =
          "CREATE OR REPLACE FUNCTION myfuncin(x VARCHAR) RETURN VARCHAR IS "
          + "BEGIN "
          + "RETURN 'a return string'||x; "
          + "END;";
      stmt.executeUpdate(function);
  
      // 创建名字为myfuncin的函数，返回VARCHAR类型
      // 带有一个名字为x的输出参数，通过PL/SQL的 return 返回
      //
      function =
          "CREATE OR REPLACE FUNCTION myfuncout(x OUT VARCHAR) RETURN VARCHAR IS "
          + "BEGIN "
          + "x:= 'outvalue'; "
          + "RETURN 'a returned string'; "
          + "END;";
      stmt.executeUpdate(function);
  

      // 创建名字为myfuncin的函数，返回VARCHAR类型
      // 带有名字为 x的输入输出参数。 作为输入参数，x 被PL/SQL 使用
      // 作为输出参数，通过 return 返回。
      //
      function =
          "CREATE OR REPLACE FUNCTION myfuncinout(x IN OUT VARCHAR) RETURN VARCHAR IS "
          + "BEGIN "
          + "x:= x||'outvalue'; "
          + "RETURN 'a returned string'; "
          + "END;";
      stmt.executeUpdate(function);
  } catch (SQLException e) {
  }

  }

}
