package com.flyong.others.lang.ref;

import java.lang.ref.SoftReference;

/**
 * SoftReference软引用的例子
 * 
 * 
 * 
 */
public class SoftReferenceTest {

  public static void main(String[] args) {
    // 创建一个软引用
    SoftReference<Object> sr = new SoftReference<Object>("TEST");

    // 使用软引用
    Object o = sr.get();
    if (o != null) {
      System.out.println(o);
    } else {
      // 对象可能已经被垃圾回收，或者再生了
    }
  }
}
