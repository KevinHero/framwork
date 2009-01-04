package com.flyong.others.lang;

import java.io.UnsupportedEncodingException;

/**
 * Unicode和UTF-8之间的转化。
 * 
 * 
 * 
 */
public class StringUnicode2UTF8 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 转化Unicode到UTF-8
      String string = "abc\u5639\u563b";
      byte[] utf8 = string.getBytes("UTF-8");

      // 从 UTF-8 转到 Unicode
      string = new String(utf8, "UTF-8");
    } catch (UnsupportedEncodingException e) {
    }

  }

}
