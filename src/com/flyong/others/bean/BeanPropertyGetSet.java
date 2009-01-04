package com.flyong.others.bean;

import java.beans.Expression;
import java.beans.Statement;

public class BeanPropertyGetSet {
  private String prop1;

  // Property prop1
  public String getProp1() {
    return prop1;
  }

  public void setProp1(String s) {
    this.prop1 = s;
  }

  private int prop2;

  // Property prop2
  public int getProp2() {
    return prop2;
  }

  public void setProp2(int i) {
    this.prop2 = i;
  }

  private byte[] PROP3;

  // Property PROP
  public byte[] getPROP3() {
    return PROP3;
  }

  public void setPROP3(byte[] bytes) {
    this.PROP3 = bytes;
  }

  public static void main(String[] args) {
    BeanPropertyGetSet o = new BeanPropertyGetSet();
    try {
      // 得到 prop1的值
      Expression expr = new Expression(o, "getProp1", new Object[0]);
      expr.execute();
      String s = (String) expr.getValue();
      System.out.println("getProp1()=" + s);

      // 设置prop1的值
      Statement stmt = new Statement(o, "setProp1",
          new Object[] { "new string" });
      stmt.execute();
      System.out.println("getProp1()=" + o.getProp1());

      // 获得prop2的值
      expr = new Expression(o, "getProp2", new Object[0]);
      expr.execute();
      int i = ((Integer) expr.getValue()).intValue();
      System.out.println("getProp2()=" + i);

      // 设置 prop2 的值
      stmt = new Statement(o, "setProp2", new Object[] { new Integer(123) });
      stmt.execute();
      System.out.println("getProp2()=" + o.getProp2());

      // 获得prop3的值
      expr = new Expression(o, "getPROP3", new Object[0]);
      expr.execute();
      byte[] bytes = (byte[]) expr.getValue();
      System.out.println("getPROP3()=" + bytes);

      // 设置prop3的值
      stmt = new Statement(o, "setPROP3", new Object[] { new byte[] { 0x12,
          0x23 } });
      stmt.execute();
      System.out.println("getPROP3()=" + o.getPROP3());
    } catch (Exception e) {
    }

  }
}
