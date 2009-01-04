package com.flyong.others.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetHostNameFromIp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // Get hostname by textual representation of IP address
      InetAddress addr = InetAddress.getByName("211.144.155.20");
      System.out.println(addr);
      System.out.println(addr.getCanonicalHostName());
      
      // Get hostname by a byte array containing the IP address
      byte[] ipAddr = new byte[] { 127, 0, 0, 1 };
      addr = InetAddress.getByAddress(ipAddr);

      // Get the host name
      String hostname = addr.getHostName();

      // Get canonical host name
      String hostnameCanonical = addr.getCanonicalHostName();
    } catch (UnknownHostException e) {
    }

  }

}
