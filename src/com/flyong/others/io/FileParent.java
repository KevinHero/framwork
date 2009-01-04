package com.flyong.others.io;

import java.io.File;

/**
 * 
 
 * 
 */
public class FileParent {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // 从相对路径得到上一级
    File file = new File("Java2000.java");
    String parentPath = file.getParent(); // null
    System.out.println(parentPath);
    File parentDir = file.getParentFile(); // null
    System.out.println(parentDir);

    // 从绝对路径得到上一级
    file = new File("D:\\workplace\\Java2000.java");
    parentPath = file.getParent(); // D:\workplace
    System.out.println(parentPath);
    parentDir = file.getParentFile(); // D:\workplace
    System.out.println(parentDir);

    parentPath = parentDir.getParent(); // D:\
    System.out.println(parentPath);
    parentDir = parentDir.getParentFile(); // D:\
    System.out.println(parentDir);

    parentPath = parentDir.getParent(); // null
    System.out.println(parentPath);
    parentDir = parentDir.getParentFile(); // null
    System.out.println(parentDir);

  }
}
