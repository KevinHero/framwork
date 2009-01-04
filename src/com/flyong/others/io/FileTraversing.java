package com.flyong.others.io;

import java.io.File;

/**
 * 遍历目录下面的子目录和文件。
 * 
 * 
 * 
 */
public class FileTraversing {

  /**
   * 处理程序
   * 
   * @param dir
   *          目录
   */
  private static void process(File dir) {

  }

  /**
   * 处理目录下面的所有文件和子目录
   * 
   * @param dir
   *          目录
   */
  public static void visitAllDirsAndFiles(File dir) {
    process(dir);

    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        visitAllDirsAndFiles(new File(dir, children[i]));
      }
    }
  }

  /**
   * 处理目录下面的所有子目录
   * 
   * @param dir
   *          目录
   */
  public static void visitAllDirs(File dir) {
    if (dir.isDirectory()) {
      process(dir);

      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        visitAllDirs(new File(dir, children[i]));
      }
    }
  }

  /**
   * 处理目录下面的所有文件
   * 
   * @param dir
   *          目录
   */
  public static void visitAllFiles(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        visitAllFiles(new File(dir, children[i]));
      }
    } else {
      process(dir);
    }
  }
}
