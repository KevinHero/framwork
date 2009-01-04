package com.flyong.others.lang;

/**
 * 系统属性的存取。
 * 
 * 
 * 
 */
public class SystemProperty {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 得到系统的属性
    String dir = System.getProperty("user.dir");
    System.out.println(dir);

    // 设置系统属性,返回以前的属性
    String previousValue = System.setProperty("application.property", "newValue");
    System.out.println(previousValue);
  }

}
