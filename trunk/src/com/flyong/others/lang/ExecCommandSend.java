package com.flyong.others.lang;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 发送数据到命令。
 * 
 * 
 * 
 */
public class ExecCommandSend {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 执行命令
      String command = "cat";
      Process child = Runtime.getRuntime().exec(command);

      // 得到输出流
      OutputStream out = child.getOutputStream();

      out.write("some text".getBytes());
      out.close();
    } catch (IOException e) {
    }

  }

}
