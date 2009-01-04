package com.flyong.others.util;

import java.util.Random;

/**
 * 生成随机整数的方法。
 * 
 * 
 * 
 */
public class RandomNumberGenerate {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Random ran = new Random();
    // 200-300之间的整数，不包括300
    System.out.println(ran.nextInt(100) + 200);

    // 使用Math的方法，转化为整数
    System.out.println((int) (Math.random() * 100) + 200);

    // 返回0-32位整数之间的，也就是整数的位数
    // 等同于 next(32),nextInt(Integer.MAX_VALUE);
    // 不过next()对外;不可见，呵呵。
    System.out.println(ran.nextInt());
  }

}
