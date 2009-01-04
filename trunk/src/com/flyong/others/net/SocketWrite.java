package com.flyong.others.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 通过Socket写入数据，并读取返回结果。
 * 
 * 
 * 
 */
public class SocketWrite {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 创建连接
      InetAddress addr = InetAddress.getByName("www.java2000.net");
      int port = 80;
      Socket socket = new Socket(addr, port);

      // 写入数据
      BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),
          "UTF-8"));
      wr.write("GET /test.jsp HTTP/1.1\r\n");
      wr.write("Host: www.java2000.net\r\n");
      wr.write("\r\n");
      wr.flush();

      // 创建读取数据的Reader,里面指定了需要的编码类型。
      BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),
          "UTF-8"));

      // 读取每一行的数据.注意大部分端口操作都需要交互数据。
      String str;
      while ((str = rd.readLine()) != null) {
        System.out.println(str);
      }
      rd.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
