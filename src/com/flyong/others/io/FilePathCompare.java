package com.flyong.others.io;

import java.io.File;
import java.io.IOException;

/**
 * 比较两个文件的路径是否相同
 * 
 * 
 * 
 */
public class FilePathCompare {

  /**
   * @param args
   */
  public static void main(String[] args) {
    File file1 = new File("./filename");
    File file2 = new File("filename");

    // 文件名并不相同，返回false
    boolean b = file1.equals(file2); // false
    System.out.println(b);

    // 将文件名标准化
    try {
      file1 = file1.getCanonicalFile(); // c:\almanac1.4\filename
      file2 = file2.getCanonicalFile(); // c:\almanac1.4\filename
    } catch (IOException e) {
    }

    // 现在相同了
    b = file1.equals(file2);
    System.out.println(b);
  }

}
