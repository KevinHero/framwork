package com.flyong.others.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取图片。
 * 
 * 
 * 
 */
public class URLGetImage {

  public static void main(String[] args) {
    try {
      // 创建指向图片的URL
      URL url = new URL("http://hostname:80/image.gif");

      // 读取图片
      java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit()
          .createImage(url);
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }

  }

}
