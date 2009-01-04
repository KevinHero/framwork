package com.flyong.others.lang;


/**
 * 读取类的package。
 * 
 * 
 * 
 */
public class GetClassPackage {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 字符串的package
    Class cls = java.lang.String.class;
    Package pkg = cls.getPackage();
    System.out.println(pkg); // package java.lang, Java Platform API
    // Specification, version 1.6

    // 这个类
    cls = GetClassPackage.class;
    pkg = cls.getPackage(); // package net.java2000.lang
    System.out.println(pkg);

    // 主类型和数组返回null
    pkg = int.class.getPackage(); // null
    System.out.println(pkg);
    pkg = int[].class.getPackage(); // null
    System.out.println(pkg);
  }

}
