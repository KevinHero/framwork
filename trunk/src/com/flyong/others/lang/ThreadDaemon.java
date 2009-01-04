package com.flyong.others.lang;

/**
 * Daemon线程的使用测试。
 * 
 * 
 * 
 */
public class ThreadDaemon extends Thread {

  public void run() {
    while (true) {
      System.out.println(".");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    ThreadDaemon t = new ThreadDaemon();
    t.setDaemon(true);
    t.start();
    t.join(500);

  }

}
