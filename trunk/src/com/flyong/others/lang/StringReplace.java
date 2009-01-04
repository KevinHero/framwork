package com.flyong.others.lang;

/**
 * 替换字符。
 * 
 * 
 * 
 */
public class StringReplace {
  public static void main(String[] args) {
    String str = "0123456789";
    System.out.println(str.replace("5", "aaa"));
    System.out.println(str.replace("[2,4,6,8]", "aaa"));
    System.out.println(str.replaceAll("5", "aaa"));
    System.out.println(str.replaceAll("[2,4,6,8]", "aaa"));
  }
}
