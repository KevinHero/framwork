package com.flyong.others.lang;

/**
 * 一个可以排序的类。
 * 
 * 
 * 
 */
public class ComparableClass implements Comparable<ComparableClass> {

  public int compareTo(ComparableClass o) {
    // 如果 this < o, 返回负数
    // 如果 this = o, 返回 0
    // 如果 this > o, 返回正数
    return 0;
  }
}
