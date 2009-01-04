package com.flyong.others.lang;

/**
 * 线程暂停的方法。
 * 
 * 
 * 
 */
public class ThreadPause {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new MyThreadPause().start();
    System.out.println("主程序运行结束，等待线程结束");
  }

}

class MyThreadPause extends Thread {
  public void run() {
    System.out.println("准备暂停1秒钟");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("暂停完毕，继续");
  }
}
