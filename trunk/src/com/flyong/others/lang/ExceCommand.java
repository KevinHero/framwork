package com.flyong.others.lang;

import java.io.IOException;

/**
 * 执行命令。
 * 
 * 
 * 
 */
public class ExceCommand {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 执行一个没有参数的命令
      String command = "ls";
      Process child = Runtime.getRuntime().exec(command);

      // 执行一个带一个参数的命令
      command = "ls /tmp";
      child = Runtime.getRuntime().exec(command);
    } catch (IOException e) {
    }

    // 如果参数包含空格，需要使用一个数组来提供参数
    try {
      // 执行一个带空格参数的命令
      String[] commands = new String[] { "grep", "hello world", "/tmp/f.txt" };
      commands = new String[] { "grep", "hello world", "c:\\Documents and Settings\\f.txt" };
      Process child = Runtime.getRuntime().exec(commands);
    } catch (IOException e) {
    }

  }
}
