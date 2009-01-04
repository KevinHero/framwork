package com.flyong.others.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用反射拿到对象的成员名字。
 * 
 * 
 * 
 */
public class ObjectMemberName {

  public static void main(String[] args) {
    // 类
    Class cls = java.lang.String.class;
    // 类所有方法的第一个
    Method method = cls.getMethods()[0];
    // 类所有属性的第一个
    Field field = cls.getFields()[0];
    // 类所有构造器的第一个
    Constructor constructor = cls.getConstructors()[0];
    String name;

    // 全名
    name = cls.getName(); // java.lang.String
    System.out.println(name);

    // 属性的全名
    name = cls.getName() + "." + field.getName(); // java.lang.String.
    System.out.println(name);

    // 构造器的名字
    name = constructor.getName(); // java.lang.String
    System.out.println(name);

    // 类的名字加上方法的名字
    name = cls.getName() + "." + method.getName(); // java.lang.String.hashCode
    System.out.println(name);

    // 非全名
    name = cls.getName().substring(cls.getPackage().getName().length() + 1); // String
    System.out.println(name);

    // 属性
    name = field.getName(); // CASE_INSENSITIVE_ORDER
    System.out.println(name);

    // 构造器
    name = constructor.getName().substring(cls.getPackage().getName().length() + 1); // String
    System.out.println(name);

    // 方法
    name = method.getName(); // hashCode
    System.out.println(name);
  }

}
