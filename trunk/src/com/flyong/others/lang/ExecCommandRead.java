package com.flyong.others.lang;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取命令行的输出。
 * 
 * 
 * 
 */
public class ExecCommandRead {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 执行命令
      String command = "cmd dir";
      Process child = Runtime.getRuntime().exec(command);

      // 得到输入流
      InputStream in = child.getInputStream();
      int c;
      while ((c = in.read()) != -1) {
        System.out.print((char) c);
      }
      in.close();
    } catch (IOException e) {
    }

  }

}
