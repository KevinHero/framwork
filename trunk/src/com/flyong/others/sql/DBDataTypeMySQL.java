package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MySQL里面与Java数据类型的对应。
 * 
 * 
 * 
 */
public class DBDataTypeMySQL {

  public static void main(String[] args) {
    try {
      Connection connection = null; // 从其它地方获取链接
      Statement stmt = connection.createStatement();

      String sql = "CREATE TABLE mysql_all_table(" + "col_boolean       BOOL, " // boolean
          + "col_byte          TINYINT, " // byte
          + "col_short         SMALLINT, " // short
          + "col_int           INTEGER, " // int
          + "col_long          BIGINT, " // long
          + "col_float         FLOAT, " // float
          + "col_double        DOUBLE PRECISION, " // double
          + "col_bigdecimal    DECIMAL(13,0), " // BigDecimal
          + "col_string        VARCHAR(254), " // String
          + "col_date          DATE, " // Date
          + "col_time          TIME, " // Time
          + "col_timestamp     TIMESTAMP, " // Timestamp
          + "col_asciistream   TEXT, " // AsciiStream (< 2^16 bytes)
          + "col_binarystream  LONGBLOB, " // BinaryStream (< 2^32 bytes)
          + "col_blob          BLOB)"; // Blob (< 2^16 bytes)

      stmt.executeUpdate(sql);
    } catch (SQLException e) {
    }

  }

}
