package com.flyong.others.io;

import java.io.File;

/**
 * 移动文件。
 * 
 *
 * 
 */
public class FileMove {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // 要移动的文件或者目录
    File file = new File("java2000");

    // 目标目录
    File dir = new File("e:\\");

    // 移动到新的目录下
    boolean success = file.renameTo(new File(dir, file.getName()));
    if (!success) {
      // 移动失败
    }

  }
}
