package com.flyong.others.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 使用DatagramPacket和DatagramSocket发送和读取数据。
 * 
 * 
 * 
 */
public class DatagramPacketReceiver {

  public static void main(String[] args) {
    try {
      new DatagramPacketReceiver.DatagramPacketSender().start();
      byte[] inbuf = new byte[256]; // 默认的数据缓冲大小
      DatagramSocket socket = new DatagramSocket(8888);

      // 等待数据
      DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
      socket.receive(packet);

      int numBytesReceived = packet.getLength();
      System.out.println(new String(inbuf, 0, numBytesReceived, "UTF-8"));
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static class DatagramPacketSender extends Thread {

    public void run() {
      try {
        Thread.sleep(1000); // 休眠1秒，等待接收服务启动
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        byte[] bs = "JAVA,2000.net".getBytes("UTF-8");
        DatagramPacket request = new DatagramPacket(bs, bs.length, ia, 8888);
        DatagramSocket socket = new DatagramSocket();
        socket.send(request);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}
