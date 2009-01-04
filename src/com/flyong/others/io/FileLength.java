package com.flyong.others.io;

import java.io.File;

/**
 * 得到文件的长度。
 * 
 * 
 * 
 */
public class FileLength {
  /**
   * @param args
   */
  public static void main(String[] args) {
    File file = new File("java2000");

    // 得到文件的字节长度
    long length = file.length();
    System.out.println(length);
  }
}
