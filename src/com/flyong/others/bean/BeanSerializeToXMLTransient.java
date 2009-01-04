package com.flyong.others.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * 
 * 
 */
public class BeanSerializeToXMLTransient {
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

  private String str;

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public String getStrTransient() {
    return strTransient;
  }

  public void setStrTransient(String strTransient) {
    this.strTransient = strTransient;
  }

  private transient String strTransient;
  static {
    try {
      // 将一个属性改造成transient
      BeanInfo info = Introspector
          .getBeanInfo(BeanSerializeToXMLTransient.class);
      PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
      for (int i = 0; i < propertyDescriptors.length; ++i) {
        PropertyDescriptor pd = propertyDescriptors[i];
        if (pd.getName().equals("props")) {
          pd.setValue("transient", Boolean.TRUE);
        }
        if (pd.getName().equals("str")) {
          pd.setValue("transient", Boolean.TRUE);
        }
      }
    } catch (IntrospectionException e) {
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建对象
    BeanSerializeToXMLTransient o = new BeanSerializeToXMLTransient();
    // 设置属性
    o.setProp(1);
    o.setProps(new int[] { 1, 2, 3 });
    o.setStr("2000.net");
    o.setStrTransient("transient.2000.net");

    try {
      // 序列化到XML
      XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
          new FileOutputStream("BeanSerializeToXMLTransient.xml")));
      encoder.writeObject(o);
      encoder.close();
    } catch (FileNotFoundException e) {
    }
  }
}
