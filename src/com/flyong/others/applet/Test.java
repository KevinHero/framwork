package com.flyong.others.applet;

import java.util.Vector;

public class Test {
  static Vector one = new Vector();
  static Vector sub = new Vector();

  public Test() {
    sub.add("val");
    sub.add("");
  }

  static void addval() {
    for (int i = 0; i < 10; i++) {
      sub = new Vector();
      sub.add("val");
      sub.add("");
      sub.setElementAt(i + "", 1);
      one.add(sub);
    }
    int i = one.size();
    while (i > 0) {

      System.out.println(((Vector) one.elementAt(i - 1)).elementAt(1).toString());
      i--;
    }
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.addval();
  }
}
