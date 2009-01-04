package com.flyong.others.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectAccessOverriding {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // 类
    Class cls = ObjectAccessOverridingO.class;
    System.out.println(cls.getName());

    // 类所有方法的第一个
    Method method = cls.getMethods()[0];
    System.out.println(method.getName());

    // 类所有属性的第一个
    System.out.println(cls.getDeclaredFields().length);
    Field field = cls.getDeclaredFields()[0];
    System.out.println(field.getName());

    // 类所有构造器的第一个
    Constructor constructor = cls.getDeclaredConstructors()[0];
    System.out.println(constructor.getName());

    field.setAccessible(true);
    constructor.setAccessible(true);
    method.setAccessible(true);

  }

}

class ObjectAccessOverridingO {
  private int privateField;

  private void privateMethod() {

  }

  private ObjectAccessOverridingO() {

  }
}
