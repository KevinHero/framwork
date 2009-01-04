package com.flyong.others.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建一个服务器端口侦听。
 * 
  * 
 */
public class ServerSocketCreate {

  public static void main(String[] args) {
    try {
      // 侦听的端口
      int port = 8200;
      ServerSocket srv = new ServerSocket(port);

      // 等待客户端的连接，此方法会阻塞，直到新的连接到来
      Socket socket = srv.accept();
    } catch (IOException e) {
    }
  }
}
