package com.flyong.others.lang;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * 获取一个类是从哪里装载的.
 * 
 * 
 * 
 */
public class GetClassLoader {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 拿到这个类的物理路径
    Class cls = GetClassLoader.class;
    ProtectionDomain pDomain = cls.getProtectionDomain();
    System.out.println(pDomain);
    CodeSource cSource = pDomain.getCodeSource();
    URL loc = cSource.getLocation();
    // file:/E:/workplaceProject/code.som.com/bin/
    System.out.println(loc);
  }

}
