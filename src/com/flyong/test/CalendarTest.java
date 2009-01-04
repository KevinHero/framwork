package com.flyong.test;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class CalendarTest {

  public static void main(String argv[]) {
    try {
      FileInputStream file = new FileInputStream(argv[0]);
      DataInputStream in = new DataInputStream(file);
      byte[] b = new byte[in.available()];
      in.readFully(b);
      in.close();
      String result = new String(b, 0, b.length, "Cp850");
      /* */
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
