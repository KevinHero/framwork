package com.flyong.others.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取数据。
 * 
 * 
 * 
 */
public class URLGet {

  public static void main(String[] args) {
    try {
      // 创建目标页面的URL
      URL url = new URL("http://hostname:80/index.html");

      // 读取所有服务器的返回的数据
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String str;
      while ((str = in.readLine()) != null) {
        // 每一行的数据，没有结尾的换行符
      }
      in.close();
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }

  }

}
