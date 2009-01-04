package com.flyong.others.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 使用URL进行POST提交。
 * 
 * 
 * 
 */
public class URLPost {

  public static void main(String[] args) {
    try {
      // 创建数据
      String data = URLEncoder.encode("key1", "UTF-8") + "="
          + URLEncoder.encode("value1", "UTF-8");
      data += "&" + URLEncoder.encode("key2", "UTF-8") + "="
          + URLEncoder.encode("value2", "UTF-8");

      // 发送数据
      URL url = new URL("http://hostname:80/cgi");
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
      OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
      wr.write(data);
      wr.flush();

      // 读取返回的数据
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
        // 处理每一行的数据
      }
      wr.close();
      rd.close();
    } catch (Exception e) {
    }

  }

}
