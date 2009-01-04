package com.flyong.others.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLServer里面与Java数据类型的对应。
 * 
 *
 * 
 */
public class DBDataTypeSQLServer {

  public static void main(String[] args) {
    try {
      Connection connection = null; // 从其它地方获取链接
      Statement stmt = connection.createStatement();
      
      String sql = "CREATE TABLE sqlserver_all_table("
          + "col_boolean          BIT, "                // boolean
          + "col_byte             TINYINT, "            // byte
          + "col_short            SMALLINT, "           // short
          + "col_int              INTEGER, "            // int
          + "col_float            REAL, "               // float
          + "col_double           DOUBLE PRECISION, "   // double
          + "col_bigdecimal       DECIMAL(13,0), "      // BigDecimal; can also be NUMERIC(p,s)
          + "col_string           VARCHAR(254), "       // String
          + "col_date             DATETIME, "           // Date
          + "col_time             DATETIME, "           // Time
          + "col_timestamp        TIMESTAMP, "          // Timestamp
          + "col_characterstream  TEXT, "               // CharacterStream or AsciiStream (< 2 GBytes)
          + "col_binarystream     IMAGE)";              // BinaryStream (< 2 GBytes)
  
      stmt.executeUpdate(sql);
  } catch (SQLException e) {
  }


  }

}
