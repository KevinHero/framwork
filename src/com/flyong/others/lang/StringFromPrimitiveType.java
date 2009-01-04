package com.flyong.others.lang;

/**
 * 转化主类型为字符串。
 * 
 * 
 * 
 */
public class StringFromPrimitiveType {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 使用 String.valueOf()
    String s = String.valueOf(true); // true
    s = String.valueOf((byte) 0x12); // 18
    s = String.valueOf((byte) 0xFF); // -1
    s = String.valueOf('a'); // a
    s = String.valueOf((short) 123); // 123
    s = String.valueOf(123); // 123
    s = String.valueOf(123L); // 123
    s = String.valueOf(1.23F); // 1.23
    s = String.valueOf(1.23D); // 1.23

    // 使用 +
    s = "" + true; // true
    s = "" + ((byte) 0x12); // 18
    s = "" + ((byte) 0xFF); // -1
    s = "" + 'a'; // a
    s = "" + ((short) 123); // 123
    s = "" + 123; // 123
    s = "" + 123L; // 123
    s = "" + 1.23F; // 1.23
    s = "" + 1.23D;

  }

}
