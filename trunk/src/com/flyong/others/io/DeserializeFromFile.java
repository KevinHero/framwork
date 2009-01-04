package com.flyong.others.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * 从文件和字节数组反序列化为对象
 * 
 * 
 * 
 */
public class DeserializeFromFile {
  /**
   * 读取文件的内容，返回字节数组。
   * 
   * @param file
   *          被读取的文件
   * @return 读取的字节数组
   * @throws IOException
   *           读取异常
   */
  public static byte[] getBytesFromFile(File file) throws IOException {
    InputStream is = new FileInputStream(file);

    // 得到文件长度
    long length = file.length();

    // 长度限制
    if (length > Integer.MAX_VALUE) {
      // 文件太大了的异常处理
      return null;
    }

    // 创建对应长度的字节数组
    // 注意，如果文件很大，这个将耗掉大量的内存
    byte[] bytes = new byte[(int) length];

    // 读取数据
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length
        && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
      offset += numRead;
    }

    // 确信所有的数据已经读取完毕
    if (offset < bytes.length) {
      throw new IOException("Could not completely read file " + file.getName());
    }

    // 关闭输入流
    is.close();
    return bytes;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 从文件反序列化
      File file = new File("java2000.ser");
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

      // 反序列化为对象
      javax.swing.JButton button = (javax.swing.JButton) in.readObject();
      in.close();
      System.out.println(button.getText());

      // 读取字节数组
      byte[] bytes = getBytesFromFile(file);

      // 反序列化为对象
      in = new ObjectInputStream(new ByteArrayInputStream(bytes));
      button = (javax.swing.JButton) in.readObject();
      in.close();
      System.out.println(button.getText());
    } catch (ClassNotFoundException e) {
    } catch (IOException e) {
    }

  }
}
