package com.flyong.others.lang;

/**
 * 判断一个字符串是否另一个字符串。
 * 
 * 
 * 
 */
public class StringContains {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String string = "Madam, I am Adam\n";

    // 以其开头
    boolean b = string.startsWith("Mad"); // true
    System.out.println(b);

    // 以其结尾
    b = string.endsWith("dam"); // true
    System.out.println(b);

    // 任何位置存在
    b = string.indexOf("I am") > 0; // true
    System.out.println(b);

    // 忽略大小写，使用正则表达式

    // 以其开头
    b = string.matches("(?i)(?s)mad.*");
    System.out.println(b);

    // 以其结尾
    b = string.matches("(?i)(?s).*adam");
    System.out.println(b);

    // 任何位置存在
    b = string.matches("(?i)(?s).*i am.*");
    System.out.println(b);
  }

}
