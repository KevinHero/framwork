package com.flyong.others.bean;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class BeanSerializeFromXML {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 反序列化一个对象
    try {
      XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
          new FileInputStream("BeanSerializeToXML.xml")));

      // 对象在另一个帖子里面已经定义，并且序列化到了XML文件
      BeanSerializeToXML o = (BeanSerializeToXML) decoder.readObject();
      decoder.close();

      // 读取属性
      int prop = o.getProp(); // 1
      System.out.println("prop=" + prop);
      int[] props = o.getProps(); // [1, 2, 3]
      System.out.println("props=" + Arrays.toString(props));
    } catch (FileNotFoundException e) {
    }

  }
}
