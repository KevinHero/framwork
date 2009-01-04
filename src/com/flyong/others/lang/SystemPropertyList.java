package com.flyong.others.lang;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 得到系统的所有属性。
 * 
 * 
 * 
 */
public class SystemPropertyList {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 得到系统的所有属性
    Properties props = System.getProperties();

    // 枚举每个系统属性的名字
    Enumeration en = props.propertyNames();
    for (; en.hasMoreElements();) {
      // 得到名字
      String propName = (String) en.nextElement();

      // 得到属性值
      String propValue = (String) props.get(propName);

      System.out.println(propName + "=" + propValue);
    }

  }
}
