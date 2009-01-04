package com.flyong.others.io;

import java.io.File;

/**
 * 列出所有的根上面的文件系统。
 * 
 *
 * 
 */
public class FileRoots {

  /**
   * @param args
   */
  public static void main(String[] args) {
    File[] roots = File.listRoots();
    for (int i = 0; i < roots.length; i++) {
      System.out.println(roots[i]);
    }

  }

}
