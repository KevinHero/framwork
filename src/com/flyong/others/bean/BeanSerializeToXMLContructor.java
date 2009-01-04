package com.flyong.others.bean;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 属性为构造器设置的。
 * 
 * 
 * 
 */
public class BeanSerializeToXMLContructor {
  int prop;

  public BeanSerializeToXMLContructor(int prop) {
    this.prop = prop;
  }

  // The immutable property
  public int getProp() {
    return prop;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建对象
    BeanSerializeToXMLContructor o = new BeanSerializeToXMLContructor(123);

    try {
      XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
          new FileOutputStream("BeanSerializeToXMLContructor.xml")));

      // 指定构造器编码
      String[] propertyNames = new String[] { "prop" };
      encoder.setPersistenceDelegate(BeanSerializeToXMLContructor.class,
          new DefaultPersistenceDelegate(propertyNames));

      // 输出
      encoder.writeObject(o);
      encoder.close();
    } catch (FileNotFoundException e) {
    }
  }
}
