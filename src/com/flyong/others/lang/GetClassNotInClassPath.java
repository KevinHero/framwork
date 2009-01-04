package com.flyong.others.lang;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 装载不再ClassPath下面的类。
 * 
 * 
 * 
 */
public class GetClassNotInClassPath {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建一个指向类根路径的文件对象
    File file = new File("c:\\myclasses\\");

    try {
      // 转化为URL
      URL url = file.toURI().toURL(); // file:/c:/myclasses/
      URL[] urls = new URL[] { url };

      // 创建一个指向那个目录的Class Loader
      ClassLoader cl = new URLClassLoader(urls);

      // 装载一个类，文件在 file:/c:/myclasses/com/mycompany 下面
      Class cls = cl.loadClass("com.mycompany.MyClass");
    } catch (MalformedURLException e) {
    } catch (ClassNotFoundException e) {
    }

  }

}
