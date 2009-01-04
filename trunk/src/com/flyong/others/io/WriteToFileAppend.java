package com.flyong.others.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 追加写入文件。<br>
 * 如果文件不存在，将自动创建一个。<br>
 * 内容将追加到文件末尾。
 * 
 * 
 * 
 */
public class WriteToFileAppend {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter("java2000", true));
      out.write("JAVA");
      out.close();
    } catch (IOException e) {
    }

  }

}
