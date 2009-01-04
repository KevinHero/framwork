package com.flyong.others.io;

import java.io.File;

/**
 * 删除目录。<br>
 * 如果存在下属的文件和目录，一块删除。
 * 
 * 
 * 
 */
public class FileDeleteDirectory {

  /**
   * 删除目录和下面的所有目录和文件。
   * 
   * @param dir
   * @return
   */
  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }

    // 目录现在是空的了，可以删除了
    return dir.delete();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    deleteDir(new File("java2000.dir"));

  }

}
