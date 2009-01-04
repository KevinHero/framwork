package com.flyong.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换数字后面的字符串为数字的数量。<br>
 * 比如 5A 则替换为 AAAAA
 * 
 * 
 * 
 */
public class TestReplace {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String str = "aaa果4金5a";
    System.out.println(encode(str));
  }

  private static Pattern pattern = Pattern.compile("(\\d+)([\u4e00-\u9fa5\\w])");

  /**
   * 替换数字后面的字符为指定数量
   * 
   * @param str
   *          被替换的字符串
   * @return 替换好的字符串
   */
  public static String encode(String str) {
    Matcher m = pattern.matcher(str);
    StringBuffer b = new StringBuffer();

    while (m.find()) {
      String temp = "";
      int times = Integer.parseInt(m.group(1));
      String ch = m.group(2);
      for (int i = 0; i < times; i++) {
        temp += ch;
      }
      m.appendReplacement(b, temp);
    }
    m.appendTail(b);
    return b.toString();
  }
}