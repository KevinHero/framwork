package com.flyong.others.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 写入文件。<br>
 * 如果文件不存在，将自动创建一个。<br>
 * 文件内容将不重写。
 * 
 * 
 * 
 */
public class WriteToFile {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter("java2000"));
      out.write("www.som.com");
      out.close();
    } catch (IOException e) {
    }

  }

}
