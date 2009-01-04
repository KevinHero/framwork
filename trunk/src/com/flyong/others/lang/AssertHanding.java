package com.flyong.others.lang;

/**
 * Assert异常的处理
 * 
 * 
 * 
 */
public class AssertHanding {
  public static void main(String[] args) {
    try {
      assert args.length > 0;
    } catch (AssertionError e) {
      // 在这种情况下，只是发生了异常，异常的信息为null
      String message = e.getMessage();
      System.out.println(message);
    }

    try {
      assert args.length > 0 : "参数不能为0";
    } catch (AssertionError e) {
      // 这里的异常信息为一个指定好的字符串
      String message = e.getMessage();
      System.out.println(message);
    }

  }

}
