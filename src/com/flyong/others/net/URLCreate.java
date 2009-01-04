package com.flyong.others.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 创建一个URL.
 * 
 * 
 * 
 */
public class URLCreate {

  public static void main(String[] args) {
    try {
      // 使用组件生成
      URL url = new URL("http", "www.java2000.net", 80, "index.jsp");

      // 使用单一的字符串
      url = new URL("http://www.java2000.net:80/index.jsp");
    } catch (MalformedURLException e) {
    }

  }

}
