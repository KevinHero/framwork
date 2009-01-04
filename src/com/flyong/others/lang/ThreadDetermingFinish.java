package com.flyong.others.lang;

/**
 * 检测线程是否结束的方法。
 * 
 * 
 * 
 */
public class ThreadDetermingFinish {

  public static void main(String[] args) {
    // 创建并启动线程
    MyThreadToDeterming thread = new MyThreadToDeterming();
    thread.start();

    // 非阻塞的方式检测线程是否完成
    if (thread.isAlive()) {
      System.out.println("线程在运行中");
    } else {
      System.out.println("线程已经结束");
    }

    // 用一段指定的时间，等待线程结束
    long delayMillis = 1000;
    try {
      System.out.println("开始等待一段时间...");
      thread.join(delayMillis);

      if (thread.isAlive()) {
        System.out.println("等待结束:线程在运行中");
      } else {
        System.out.println("等待结束:线程已经结束");
      }
    } catch (InterruptedException e) {
      System.out.println("等待被中断了");
    }

    // 等待线程结束
    try {
      System.out.println("开始等待直到结束...");
      thread.join();
      System.out.println("线程已经结束");
    } catch (InterruptedException e) {
      System.out.println("等待被中断了");
    }

  }

}

class MyThreadToDeterming extends Thread {
  public void run() {
    int i = 20;
    while (i-- > 0) {
      // 我们故意让这个线程休眠100毫秒
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(this.getClass().getName() + " is running...");
    }
    System.out.println(this.getClass().getName() + " is stopping...");
  }
}