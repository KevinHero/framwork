package com.flyong.others.lang;

/**
 * 线程等待和Notify的使用
 * 
 * 
 * 
 */
public class ThreadNotifyTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MyThreadNotify t = new MyThreadNotify();
    t.start();
    while (!t.waiting) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    synchronized (t) {
      t.notify();
    }
    System.out.println("主程序运行结束，等待线程结束");
  }

}

class MyThreadNotify extends Thread {
  boolean waiting = false;

  public void run() {
    System.out.println("准备暂停");
    synchronized (this) {
      try {
        waiting = true;
        wait(); // 等待
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("暂停完毕，继续");
  }
}
