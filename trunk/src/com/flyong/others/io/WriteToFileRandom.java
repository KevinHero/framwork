package com.flyong.others.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入文件数据。
 * 
 * 
 * 
 */
public class WriteToFileRandom {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      File f = new File("java2000");
      RandomAccessFile raf = new RandomAccessFile(f, "rw");

      // 读取数据
      char ch = raf.readChar();
      System.out.println(ch);

      // 移动指针到文件末尾
      raf.seek(f.length());

      // 追加到末尾
      raf.write("增加一个尾巴".getBytes("UTF-8"));
      raf.close();
    } catch (IOException e) {
    }

  }

}
