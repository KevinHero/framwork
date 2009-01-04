package com.flyong.others.lang;

/**
 * 侦听系统的终止事件，做自己要做的扫尾工作
 * 
 * 
 * 
 */
public class TerminateLisenerApp {

  public static void main(String[] args) {
    try {
      // 注册一个终止线程
      Runtime.getRuntime().addShutdownHook(new Thread() {
        // 这个方法在系统终止前被调用
        public void run() {
          // 做一些工作，比如
          System.out.println("OK，同意终止!");
        }
      });
    } finally {
      System.out.println("In Finally!");
    }
  }
}
