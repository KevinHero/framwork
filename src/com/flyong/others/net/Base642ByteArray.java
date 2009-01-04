package com.flyong.others.net;

import java.io.IOException;

/**
 * Base64字符串和字节数组的相互转换。
 * 
 *
 * 
 */
public class Base642ByteArray {

  public static void main(String[] args) {
    try {
      // 把一个字节数组转化为Base64的字符串
      byte[] buf = new byte[] { 0x12, 0x23 };
      String s = new sun.misc.BASE64Encoder().encode(buf);

      // 转化Base64的字符串转化为字节数组
      buf = new sun.misc.BASE64Decoder().decodeBuffer(s);
    } catch (IOException e) {
    }

  }

}
