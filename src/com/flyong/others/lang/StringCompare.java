package com.flyong.others.lang;

/**
 * 字符串比较。
 * 
 * 
 * 
 */
public class StringCompare {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String s1 = "a";
    String s2 = "A";
    String s3 = "B";

    // 检查是否相等
    boolean b = s1.equals(s2); // false
    System.out.println(b);

    // 检查是否相等，忽略大小写
    b = s1.equalsIgnoreCase(s2); // true

    // 检查2个字符串的先后顺序
    int i = s1.compareTo(s2); // 32; 小写字母在大写字母后面
    if (i < 0) {
      // s1 在 s2 前面
    } else if (i > 0) {
      // s1 在 s2 后面
    } else {
      // s1 和 s2 相等
    }
    System.out.println(i);

    // 检查2个字符串的顺序，忽略大小写
    i = s1.compareToIgnoreCase(s3); // -1
    if (i < 0) {
      // s1 在 s3 前面
    } else if (i > 0) {
      // s1 在 s3 后面
    } else {
      // s1 和 s3 相等
    }
    System.out.println(i);

    // 字符串也可以和StringBuffer进行比较
    StringBuffer sbuf = new StringBuffer("a");
    b = s1.contentEquals(sbuf); // true
    System.out.println(b);
  }

}
