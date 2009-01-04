package com.flyong.others.lang;

import java.util.Arrays;

/**
 * 拿到类实现的所有接口。
 * 
 * 
 * 
 */
public class GetClassInterfaceImplements {
  public static void main(String[] args) {
    // 字符串可是实现了不少的接口哦
    Class cls = java.lang.String.class;
    Class[] intfs = cls.getInterfaces();
    System.out.println(Arrays.toString(intfs));
    // [java.lang.Comparable, java.lang.CharSequence, java.io.Serializable]

    // 主类型没有实现接口
    cls = int.class;
    intfs = cls.getInterfaces(); // []
    System.out.println(Arrays.toString(intfs));

    // 主类型的封装类型呢？
    cls = Integer.class;
    intfs = cls.getInterfaces(); // [interface java.lang.Comparable]
    System.out.println(Arrays.toString(intfs));
  }
}
