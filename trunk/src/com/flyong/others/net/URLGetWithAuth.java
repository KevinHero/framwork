package com.flyong.others.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

/**
 * 访问被密码保护的URL页面
 * 
 *
 * 
 */
public class URLGetWithAuth {

  public static void main(String[] args) {
    class MyAuthenticator extends Authenticator {
      // 在访问一个被密码保护的URL时，这个方法被调用
      protected PasswordAuthentication getPasswordAuthentication() {
        // 获得请求信息
        String promptString = getRequestingPrompt();
        String hostname = getRequestingHost();
        InetAddress ipaddr = getRequestingSite();
        int port = getRequestingPort();

        // 用户名
        String username = "myusername";

        // 密码
        String password = "mypassword";

        // 返回认证信息
        return new PasswordAuthentication(username, password.toCharArray());
      }
    }
    // 设置默认的客户认证机制
    Authenticator.setDefault(new MyAuthenticator());

    // 访问页面
    try {
      // 创建目标页面的URL
      URL url = new URL("http://hostname:80/index.html");

      // 读取服务器返回的所有文本
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String str;
      while ((str = in.readLine()) != null) {
        // 每一行的数据，不包括结尾的换行符
      }
      in.close();
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }

  }

}
