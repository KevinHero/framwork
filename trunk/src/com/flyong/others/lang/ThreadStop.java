package com.flyong.others.lang;

/**
 * 终止线程的方法。
 * 
 * 
 * 
 */
public class ThreadStop {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MyThreadToStop t = new MyThreadToStop();
    new Thread(t).start();
    // 我们休眠1秒钟
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 让线程终止
    t.setStop(true);
  }

}

class MyThreadToStop implements Runnable {
  private boolean stop = false;

  public boolean isStop() {
    return stop;
  }

  public void setStop(boolean stop) {
    this.stop = stop;
  }

  public void run() {
    while (!stop) {
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