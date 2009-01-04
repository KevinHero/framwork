package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Oracle里面与Java数据类型的对应。
 * 
 * 
 * 
 */
public class DBDataTypeOracle {

  public static void main(String[] args) {
    try {
      Connection connection = null; // 从其它地方获取链接

      Statement stmt = connection.createStatement();

      // 创建动态数组VARRAY类型
      stmt.execute("CREATE TYPE number_varray AS VARRAY(10) OF NUMBER(12, 2)");

      // 创建对象类型
      stmt
          .execute("CREATE TYPE my_object AS OBJECT(col_string2 VARCHAR(30),col_int2 INTEGER)");

      String sql = "CREATE TABLE oracle_all_table(" 
          + "col_short           SMALLINT, " // short
          + "col_int             INTEGER, " // int
          + "col_float           REAL, " // float; can also be NUMBER
          + "col_double          DOUBLE PRECISION, " // double; can also be
          // FLOAT or NUMBER
          + "col_bigdecimal      DECIMAL(13,0), " // BigDecimal
          + "col_string          VARCHAR2(254), " // String; can also be CHAR(n)
          + "col_characterstream LONG, " // CharacterStream or AsciiStream
          + "col_bytes           RAW(2000), " // byte[]; can also be LONG RAW(n)
          + "col_binarystream    RAW(2000), " // BinaryStream; can also be LONG
          // RAW(n)
          + "col_timestamp       DATE, " // Timestamp
          + "col_clob            CLOB, " // Clob
          + "col_blob            BLOB, " // Blob; can also be BFILE
          + "col_array           number_varray, " // oracle.sql.ARRAY
          + "col_object          my_object)"; // oracle.sql.OBJECT

      stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
