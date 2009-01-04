package com.flyong.others.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 文件路径和URL的互相转化。
 * 
 * 
 * 
 */
public class FilePathURL {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建文件对象
    File file = new File("outfilename.xml");

    // 转化为URL
    URL url = null;
    try {
      // 路径前面会自动加上工作目录
      // 使用绝对地址
      // 直接的 toURL已经不建议使用，因为没有处理特殊字符
      url = file.toURI().toURL();
      System.out.println(url); 

    } catch (MalformedURLException e) {
    }

    // 转化URL为文件对象
    file = new File(url.getFile()); // d:/almanac1.4/java.io/filename

    // 用URL读取数据
    try {
      // 打开输入流
      InputStream is = url.openStream();

      // 从输入流读取

      // 关闭输入流
      is.close();
    } catch (IOException e) {
      // 打不开文件等异常
    }

  }
}
