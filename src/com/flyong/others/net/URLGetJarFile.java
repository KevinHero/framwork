package com.flyong.others.net;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 使用URL存取jar文件。
 * 
 * 
 * 
 */
public class URLGetJarFile {

  public static void main(String[] args) {
    try {
      // 创建指向jar文件的URL
      URL url = new URL("jar:http://hostname/my.jar!/");

      // 创建指向文件系统的URL
      url = new URL("jar:file:/c:/almanac/my.jar!/");

      // 读取jar文件
      JarURLConnection conn = (JarURLConnection) url.openConnection();
      JarFile jarfile = conn.getJarFile();

      // 如果URL没有任何入口，则名字为null
      String entryName = conn.getEntryName(); // null

      // 创建一个指向jar文件里一个入口的URL
      url = new URL("jar:file:/c:/almanac/my.jar!/com/mycompany/MyClass.class");

      // 读取jar文件
      conn = (JarURLConnection) url.openConnection();
      jarfile = conn.getJarFile();

      // 此时的入口名字应该和指定的URL相同
      entryName = conn.getEntryName();

      // 得到jar文件的入口
      JarEntry jarEntry = conn.getJarEntry();
    } catch (MalformedURLException e) {
    } catch (IOException e) {
    }

  }

}
