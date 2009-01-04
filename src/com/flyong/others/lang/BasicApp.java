package com.flyong.others.lang;

/**
 * Java应用的参数。
 * 
 *
 * 
 */
public class BasicApp {
  public static void main(String[] args) {
    // 处理参数
    // 第一个参数从0开始，比如
    // java BasicApp param0 param1 param2
    // 命令行里面的 java 和 BaseiApp 是不包含在参数里面的。
    for (int i = 0; i < args.length; i++) {
      // 处理参数 args[i];
      // 比如输出到控制台
      System.out.println(args[i]);
    }
  }
}
