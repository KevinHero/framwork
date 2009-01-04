package com.flyong.others.lang;

/**
 * 创建线程的2个方法。
 * 
 * 
 * 
 */
public class ThreadCreate {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new MyThread1().start();
    new Thread(new MyThread2()).start();

  }

}

class MyThread1 extends Thread {
  public void run() {
    // 我们故意让这个线程休眠100毫秒
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getClass().getName() + " is running...");
  }
}

class MyThread2 implements Runnable {
  public void run() {
    System.out.println(this.getClass().getName() + " is running...");
  }
}
