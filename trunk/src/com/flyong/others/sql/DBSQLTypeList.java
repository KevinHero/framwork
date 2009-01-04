package com.flyong.others.sql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 得到数据库支持的数据类型.
 * 
 * 
 * 
 */
public class DBSQLTypeList {

  public static void main(String[] args) {
    Connection connection = null; // 从其它地方获取链接
    try {
      DatabaseMetaData dbmd = connection.getMetaData();

      // 得到类型信息
      ResultSet resultSet = dbmd.getTypeInfo();

      while (resultSet.next()) {
        // 得到数据库指定的类型名
        String typeName = resultSet.getString("TYPE_NAME");

        // 得到 java.sql.Type 映射的类型
        short dataType = resultSet.getShort("DATA_TYPE");

      }

    } catch (SQLException e) {
    }

  }

  // 得到一个JDBC Type名字
  public static String getJdbcTypeName(int jdbcType) {
    // Use reflection to populate a map of int values to names
    if (map == null) {
      map = new HashMap();

      // Get all field in java.sql.Types
      Field[] fields = java.sql.Types.class.getFields();
      for (int i = 0; i < fields.length; i++) {
        try {
          // Get field name
          String name = fields[i].getName();

          // Get field value
          Integer value = (Integer) fields[i].get(null);

          // Add to map
          map.put(value, name);
        } catch (IllegalAccessException e) {
        }
      }
    }

    // Return the JDBC type name
    return (String) map.get(new Integer(jdbcType));
  }

  static Map map;

}
