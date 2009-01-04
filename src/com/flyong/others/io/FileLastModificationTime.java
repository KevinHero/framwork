package com.flyong.others.io;

import java.io.File;
import java.util.Date;

/**
 * 更新文件的最后修改时间
 * 
 * 
 * 
 */
public class FileLastModificationTime {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 文件名
    File file = new File("java2000");

    // 得到最后的修改时间
    // 如果文件不存在，则返回0L
    long modifiedTime = file.lastModified();
    System.out.println(new Date(modifiedTime));

    // 设置新的修改时间
    long newModifiedTime = System.currentTimeMillis();
    boolean success = file.setLastModified(newModifiedTime);
    if (!success) {
      // 操作失败
    }

  }

}
