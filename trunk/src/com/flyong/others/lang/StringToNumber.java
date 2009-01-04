package com.flyong.others.lang;

/**
 * 从字符串转化为数字。
 * 
 *
 * 
 */
public class StringToNumber {

  /**
   * @param args
   */
  public static void main(String[] args) {
    byte b = Byte.parseByte("123");
    short s = Short.parseShort("123");
    int i = Integer.parseInt("123");
    long l = Long.parseLong("123");
    float f = Float.parseFloat("123.4");
    double d = Double.parseDouble("123.4e10");
  }

}
