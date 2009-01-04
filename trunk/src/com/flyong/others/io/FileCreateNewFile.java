package com.flyong.others.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建一个新的文件。<br>
 * 如果文件已经存在，则创建失败。
 * 
 * 
 * 
 */
public class FileCreateNewFile {
  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      File file = new File("java2000");

      // 如果文件不存在，则创建一个新的
      boolean success = file.createNewFile();
      if (success) {
        System.out.println("创建成功");
      } else {
        System.out.println("创建失败，文件已经存在");
      }
    } catch (IOException e) {
    }

  }
}
