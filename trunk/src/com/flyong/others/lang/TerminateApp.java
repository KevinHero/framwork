package com.flyong.others.lang;

/**
 * 强制终止程序。
 * 
 * 
 * 
 */
public class TerminateApp {

  public static void main(String[] args) {
    // 没有错误，返回0
    int errorCode = 0;

    // 有错误发生，返回自定义的错误编码
    errorCode = -1;

    // 强行终止程序
    System.exit(errorCode);
    if (true) {
      System.out.println(1234);
    }
  }

}
