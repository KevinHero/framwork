package com.flyong.others.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 序列化对象到文件和字节数组
 * 
 * 
 * 
 */
public class SerializeToFile {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // 构造一个按钮对象
    Object object = new javax.swing.JButton("JAVA2000.NET");

    try {
      // 序列化到文件
      ObjectOutput out = new ObjectOutputStream(new FileOutputStream("java2000.ser"));
      out.writeObject(object);
      out.close();

      // 序列化到字节数组流
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      out = new ObjectOutputStream(bos);
      out.writeObject(object);
      out.close();

      // 拿到序列化对象的字节数组
      byte[] buf = bos.toByteArray();
    } catch (IOException e) {
    }

  }

}
