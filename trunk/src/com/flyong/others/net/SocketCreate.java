package com.flyong.others.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 创建Socket连接
 * 
 *
 */
public class SocketCreate {

  public static void main(String[] args) {
    // 创建一个Socket,不限连结超时
    try {
      InetAddress addr = InetAddress.getByName("www.java2000.net");
      int port = 80;

      // 这个构造方法会阻塞，直到连结成功
      Socket socket = new Socket(addr, port);
      System.out.println(socket);

    } catch (UnknownHostException e) {
    } catch (IOException e) {
    }

    // 指定Socket连结的超时时间
    try {
      // 这里故意把域名弄错
      InetAddress addr = InetAddress.getByName("www.java20002.net");
      int port = 80;
      SocketAddress sockaddr = new InetSocketAddress(addr, port);

      // 创建一个无限制的Socket
      Socket sock = new Socket();

      // 这个连结尝试将最多等待2秒钟，如果连结失败将抛出SocketTimeoutException
      int timeoutMs = 2000;
      sock.connect(sockaddr, timeoutMs);
      System.out.println(sock);
    } catch (UnknownHostException e) {
    } catch (SocketTimeoutException e) {
      e.printStackTrace();
    } catch (IOException e) {
    }

  }

}
