package com.flyong.others.io;

import java.io.File;

/**
 * 判断一个File是否存在。
 * 
 * 
 * 
 */
public class FileIsExists {

  /**
   * @param args
   */
  public static void main(String[] args) {
    boolean exists = (new File("java2000")).exists();
    if (exists) {
      System.out.println("目录或者文件存在");
    } else {
      System.out.println("目录或者文件不存在");
    }

  }

}
