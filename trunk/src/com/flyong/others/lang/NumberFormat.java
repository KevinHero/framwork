package com.flyong.others.lang;

/**
 * 字符串和数字进制之间的转换。
 * 
 * 
 * 
 */
public class NumberFormat {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int i = 1023;

    // 二进制的转换
    i = Integer.parseInt("1111111111", 2); // 1023
    String s = Integer.toString(i, 2); // 1111111111

    // 八进制的转换
    i = Integer.parseInt("1777", 8); // 1023
    s = Integer.toString(i, 8); // 1777

    // 十进制的转换
    i = Integer.parseInt("1023"); // 1023
    s = Integer.toString(i); // 1023

    // 十六进制的转换
    i = Integer.parseInt("3ff", 16); // 1023
    s = Integer.toString(i, 16); // 3ff

    // 其它进制的转换 radix <= Character.MAX_RADIX
    int radix = 32;
    i = Integer.parseInt("vv", radix); // 1023
    s = Integer.toString(i, radix); // vv

  }
}
