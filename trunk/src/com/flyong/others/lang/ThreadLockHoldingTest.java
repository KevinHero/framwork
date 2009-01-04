package com.flyong.others.lang;

/**
 * 线程对同步锁的检测。
 * 
 * 
 * 
 */
public class ThreadLockHoldingTest {

  public synchronized void myMethod() {
    boolean hasLock = false;
    Object o = new Object();

    // 检测当前线程是否拿到了对象的锁
    hasLock = Thread.holdsLock(o); // false
    System.out.println(hasLock);
    synchronized (o) {
      // 同步对象
      hasLock = Thread.holdsLock(o); // true
      System.out.println(hasLock);
    }
    // 结束同步
    hasLock = Thread.holdsLock(o);
    System.out.println(hasLock);

    // 检查当前线程是否拥有当前对象实例的锁
    hasLock = Thread.holdsLock(this); // true
    System.out.println(hasLock);
  }

  public static void main(String[] args) {
    new ThreadLockHoldingTest().myMethod();
  }

}
