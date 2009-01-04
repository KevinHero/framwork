package com.flyong.others.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从标准输入读取数据。
 * 
 *
 * 
 */
public class ReadFromStandardInput {
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
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String str = "";
      while (str != null) {
        System.out.print("> prompt ");
        str = in.readLine();
        process(str);
      }
    } catch (IOException e) {
    }

  }

}
