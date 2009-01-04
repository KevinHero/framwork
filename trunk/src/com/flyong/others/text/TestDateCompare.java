package com.flyong.others.text;

import java.util.Calendar;

public class TestDateCompare {

  public static void main(String[] args) {
    String DATE_FORMAT = "yyyy-MM-dd";
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.set(1999, 12, 31);
    c2.set(1999, 0, 30);

    System.out.print(sdf.format(c1.getTime()));

    if (c1.before(c2)) {
      System.out.print(" is before ");
    }
    if (c1.after(c2)) {
      System.out.print(" is after ");
    }
    if (c1.equals(c2)) {
      System.out.print(" same as ");
    }
    System.out.print(sdf.format(c2.getTime()));
  }
}
