package com.flyong.others.io;

import java.io.File;

/**
 * 文件更名。
 * 
 * 
 * 
 */
public class FileRename {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 以前的文件或者目录的名字
    File file = new File("java");

    // 新的文件或者目录的名字
    File file2 = new File("som.com.net");

    // 更名
    boolean success = file.renameTo(file2);
    if (!success) {
      System.out.println("更名失败，是否原文件不存在，或者新的名字对应的文件或目录已经存在?");
    }

  }

}
