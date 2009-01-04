package com.flyong.others.lang;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * 读取类的父类。
 * 
 * 
 * 
 */
public class GetSuperClass {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Object o = new String();
    Class sup = o.getClass().getSuperclass();
    System.out.println(sup); // java.lang.Object

    // Object的父类是null
    o = new Object();
    sup = o.getClass().getSuperclass();
    System.out.println(sup); // null

    // 虽然o2是一个接口，但其返回了真实对象的父类
    Runnable o2 = new Runnable() {
      public void run() {
      }
    };
    sup = o2.getClass().getSuperclass();
    System.out.println(sup); // java.lang.Object

    BufferedReader f = new BufferedReader(new StringReader(""));
    sup = f.getClass().getSuperclass();
    System.out.println(sup); // class java.io.Reader
  }

}
