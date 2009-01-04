package com.flyong.others.io;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 强制刷新数据写入磁盘。
 * 
 * 
 * 
 */
public class FileForceUpdateToDisk {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 打开或者新建一个文件
      FileOutputStream os = new FileOutputStream("java2000");
      FileDescriptor fd = os.getFD();

      // 写一些数据
      byte[] data = new byte[] { (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE };
      os.write(data);

      // 刷新输出流的数据，写入到系统的缓冲区
      // 数据可能没有真正的写入到磁盘上
      os.flush();

      // 阻塞系统，直到系统的缓冲已经写到了磁盘.
      fd.sync();
    } catch (IOException e) {
    }

  }

}
