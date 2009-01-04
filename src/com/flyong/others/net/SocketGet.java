package com.flyong.others.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 通过Socket读取返回的数据。
 * 
 * 
 * 
 */
public class SocketGet {

  public static void main(String[] args) {
    try {
      // 创建连接
      InetAddress addr = InetAddress.getByName("smtp.163.com");
      int port = 25;
      Socket socket = new Socket(addr, port);
      
      // 如果超过这个时间没有新的数据，则不再继续等待数据
      socket.setSoTimeout(1000);

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
