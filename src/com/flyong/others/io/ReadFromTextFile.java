package com.flyong.others.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 从文本文件读取数据。
 * 
 * 
 * 
 */
public class ReadFromTextFile {
  /**
   * 处理程序
   * 
   * @param dir
   *          目录
   */
  private static void process(String str) {
    System.out.println(str);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedReader in = new BufferedReader(new FileReader("java2000"));
      String str;
      while ((str = in.readLine()) != null) {
        process(str);
      }
      in.close();
    } catch (IOException e) {
    }

  }
}
