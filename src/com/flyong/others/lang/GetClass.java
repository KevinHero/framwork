package com.flyong.others.lang;

/**
 * 拿到一个类的三种方式。
 * 
 *
 * 
 */
public class GetClass {
  public static void main(String[] args) {
    String object = "som.com";
    // 从类的实例拿到
    Class cls = object.getClass();
    System.out.println(cls);

    // 从类名拿到
    try {
      cls = Class.forName("java.lang.String");
      System.out.println(cls);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    // 从 .class 拿到
    cls = java.lang.String.class;
    System.out.println(cls);
  }
}
