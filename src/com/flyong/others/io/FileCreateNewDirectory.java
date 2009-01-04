package com.flyong.others.io;

import java.io.File;

/**
 * 创建目录。<br>
 * 可以指定是否自定创建上级目录。
 * 
 *
 * 
 */
public class FileCreateNewDirectory {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建一个目录。目录的所有上级目录必须存在
    boolean success = (new File("java2000.dir")).mkdir();
    if (!success) {
      // 目录创建失败
    }

    // Create a directory; all non-existent ancestor directories are
    // automatically created
    // 创建一个目录。如果目录的上级目录不存在，则自动创建
    success = (new File("java2000.dir")).mkdirs();
    if (!success) {
      // 创建失败
    }

  }

}
