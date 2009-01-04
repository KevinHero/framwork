package com.flyong.others.lang;

/**
 * 线程变量的使用 ThreadLocal。<br>
 * 内部其实就是一个和线程ID相关的Map.<br>
 * 每个ID会自动产生一个Map的值。
 * 
 * 
 * 
 */
public class ThreadLocalVar {
  // 定义一个线程相关的变量。
  static ThreadLocal tlData = new ThreadLocal();

  /**
   * 一个使用方法。
   */
  public void aMethod() {
    // 拿到变量的值
    Object o = tlData.get();

    // 设置变量
    tlData.set(o);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ThreadLocalVar().aMethod();

  }

}
