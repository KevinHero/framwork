package com.flyong.others.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 读写属性文件。
 * 
 * 
 * 
 */
public class PropertiesReadWrite {

  public static void main(String[] args) {

    // Read properties file.
    Properties prop = new Properties();

    try {
      prop.load(new FileInputStream("filename.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(prop.size());
    System.out.println(prop.get("aaa"));
    System.out.println(prop.getProperty("c"));
    System.out.println(prop.getProperty("d.e.f"));
    // Write properties file.
    try {
      prop.store(new FileOutputStream("filename.properties"), null);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
