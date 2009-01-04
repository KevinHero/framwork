package com.flyong.others.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 解析URL.
 * 
 *
 * 
 */
public class URLParseing {

  public static void main(String[] args) {
    try {
      URL url = new URL("http://www.java2000.net:80/index.jsp#_top_");

      String protocol = url.getProtocol(); // http
      System.out.println(protocol);

      String host = url.getHost(); // hostname
      System.out.println(host);

      int port = url.getPort(); // 80
      System.out.println(port);

      String file = url.getFile(); // index.html
      System.out.println(file);

      String ref = url.getRef(); // _top_
      System.out.println(ref);

    } catch (MalformedURLException e) {
    }

  }

}
