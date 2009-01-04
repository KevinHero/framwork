package com.flyong.others.lang;

/**
 * 检测一个字符是否为unicode部分。
 * 
 * 
 */
public class StringUnicodeDetermining {

  /**
   * @param args
   */
  public static void main(String[] args) {
    char ch = '\u5639';
    Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
    System.out.println(block);
    ch = 123;
    block = Character.UnicodeBlock.of(ch);
    System.out.println(block);
  }

}
