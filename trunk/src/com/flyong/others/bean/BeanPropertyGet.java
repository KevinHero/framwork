package com.flyong.others.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class BeanPropertyGet {
  // Property prop1
  public String getProp1() {
    return null;
  }

  public void setProp1(String s) {
  }

  // Property prop2
  public int getProp2() {
    return 0;
  }

  public void setProp2(int i) {
  }

  // Property PROP
  public byte[] getPROP3() {
    return null;
  }

  public void setPROP3(byte[] bytes) {
  }

  public static void main(String[] args) {
    try {
      BeanInfo bi = Introspector.getBeanInfo(BeanPropertyGet.class);
      PropertyDescriptor[] pds = bi.getPropertyDescriptors();
      for (PropertyDescriptor pd : pds) {
        System.out.println(pd.getName());
        System.out.println(pd.getPropertyType());
        System.out.println(pd.getReadMethod());
        System.out.println(pd.getWriteMethod());
      }
    } catch (java.beans.IntrospectionException e) {
    }

  }
}
