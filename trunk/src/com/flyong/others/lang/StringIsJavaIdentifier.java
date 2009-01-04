package com.flyong.others.lang;

/**
 * 检测一个字符串是否为一个Java合法的标识符.
 * 
 * 
 * 
 */
public class StringIsJavaIdentifier {

  /**
   * 检测一个字符串是否为一个Java合法的标识符。
   * 
   * @param s
   *          被检测的字符串
   * @return 合法返回true,不合法返回false
   */
  public static boolean isJavaIdentifier(String s) {
    if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
      return false;
    }
    for (int i = 1; i < s.length(); i++) {
      if (!Character.isJavaIdentifierPart(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    boolean b = isJavaIdentifier("my_var"); // true
    System.out.println(b);

    b = isJavaIdentifier("my_var.1"); // false
    System.out.println(b);

    b = isJavaIdentifier("$my_var"); // true
    System.out.println(b);

    b = isJavaIdentifier("\u0391var"); // true
    System.out.println(b);

    b = isJavaIdentifier("_"); // true
    System.out.println(b);

    b = isJavaIdentifier("$"); // true
    System.out.println(b);

    b = isJavaIdentifier("1$my_var"); // false
    System.out.println(b);
  }
}
