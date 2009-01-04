package com.flyong.others.bean;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * 
 * 
 */
public class BeanSerializeToXML {
  // The prop property
  int i;

  public int getProp() {
    return i;
  }

  public void setProp(int i) {
    this.i = i;
  }

  // The props property
  int[] iarray = new int[0];

  public int[] getProps() {
    return iarray;
  }

  public void setProps(int[] iarray) {
    this.iarray = iarray;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建对象
    BeanSerializeToXML o = new BeanSerializeToXML();
    // 设置属性
//    o.setProp(1);
//    o.setProps(new int[] { 1, 2, 3 });

    try {
      // 序列化到XML
      XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
          new FileOutputStream("BeanSerializeToXML.xml")));
      encoder.writeObject(o);
      encoder.close();
    } catch (FileNotFoundException e) {
    }
  }

}
