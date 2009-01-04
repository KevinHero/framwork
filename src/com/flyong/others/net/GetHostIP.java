package com.flyong.others.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 得到指定主机的所有IP.<br>
 * 实际效果取决于DNS的设置。
 * 
 * 
 * 
 */
public class GetHostIP {

  public static void main(String[] args) {
    try {
      // 根据名字读取全部的IP地址信息。
      InetAddress[] addrs = InetAddress.getAllByName("www.sina.com.cn");
      for (InetAddress addr : addrs) {
        // 拿到地址
        byte[] ipAddr = addr.getAddress();

        // 组装成字符串
        StringBuilder ipAddrStr = new StringBuilder();
        for (int i = 0; i < ipAddr.length; i++) {
          if (i > 0) {
            ipAddrStr.append(".");
          }
          ipAddrStr.append(ipAddr[i] & 0xFF);
        }
        System.out.println(ipAddrStr);
      }
    } catch (UnknownHostException e) {
    }

  }

}
