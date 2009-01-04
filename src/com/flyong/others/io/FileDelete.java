package com.flyong.others.io;

import java.io.File;

/**
 * 删除文件。
 * 
 * 
 * 
 */
public class FileDelete {

  /**
   * @param args
   */
  public static void main(String[] args) {
    boolean success = (new File("java2000")).delete();
    if (!success) {
      System.out.println("删除失败!");
    } else {
      System.out.println("删除成功!");
    }

  }

}
