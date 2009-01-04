package com.flyong.others.io;

import java.io.File;

/**
 * 判断一个File对象是文件还是目录。
 * 
 * 
 * 
 */
public class FileIsFileOrDirectory {

  /**
   * @param args
   */
  public static void main(String[] args) {
    File dir = new File("java2000");

    boolean isDir = dir.isDirectory();
    if (isDir) {
      System.out.println("是一个目录");
    } else {
      System.out.println("是一个文件");
    }

  }

}
