package com.flyong.others.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 使用DatagramPacket和DatagramSocket发送数据。
 * 
 *  * 
 */
public class DatagramPacketSend {

  public static void main(String[] args) throws Exception {
    InetAddress ia = InetAddress.getByName("127.0.0.1");
    byte[] bs = "JAVA,2000.net".getBytes("UTF-8");
    send(ia, 8888, bs, bs.length);
  }

  /**
   * 发送数据包
   * 
   * @param dst
   *          目标
   * @param port
   *          端口
   * @param outbuf
   *          数据数组
   * @param len
   *          长度
   */
  public static void send(InetAddress dst, int port, byte[] outbuf, int len) {
    try {
      DatagramPacket request = new DatagramPacket(outbuf, len, dst, port);
      DatagramSocket socket = new DatagramSocket();
      socket.send(request);
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
