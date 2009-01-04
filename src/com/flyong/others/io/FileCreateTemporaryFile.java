package com.flyong.others.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 创建临时文件。
 * 
 * 
 * 
 */
public class FileCreateTemporaryFile {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 创建临时文件
      File temp = File.createTempFile("java2000", ".suffix");

      // 设置程序退出时删除这个文件
      temp.deleteOnExit();

      // 向临时文件写数据
      BufferedWriter out = new BufferedWriter(new FileWriter(temp));
      out.write("www.som.com");
      out.close();
    } catch (IOException e) {
    }
  }
}
