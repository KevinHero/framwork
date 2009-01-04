package com.flyong.others.reflect;

import java.lang.reflect.Modifier;

/**
 * 检测一个类的存取描述符。
 * 
 * 
 * 
 */
public class ObjectModifier {

  public static void main(String[] args) {
    Class cls = java.lang.String.class;
    int mods = cls.getModifiers();
    if (Modifier.isPublic(mods)) {
      System.out.println("public");
    }

  }
}
