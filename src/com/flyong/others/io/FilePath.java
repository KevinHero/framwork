package com.flyong.others.io;

import java.io.File;

/**
 * 构造文件的路径。兼容Windows和unix/linux
 * 
 * 
 * 
 */
public class FilePath {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String path = File.separator + "a" + File.separator + "b";
    System.out.println(path);
  }

}
