package com.flyong.others.lang;

/**
 * 对象的复制 Clone.
 * 
 * 
 * 
 */
public class CloneableClass implements Cloneable {

  public Object clone() {
    Cloneable theClone = new CloneableClass();
    // 初始化数据
    // 然后返回
    return theClone;
  }

  public static void main(String[] args) {
    CloneableClass myObject = new CloneableClass();
    CloneableClass myObjectClone = (CloneableClass) myObject.clone();

    // 数组自动可以Clone
    int[] ints = new int[] { 123, 234 };
    int[] intsClone = (int[]) ints.clone();

  }

}
