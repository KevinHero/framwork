package com.flyong.others.util;

import java.util.Calendar;

public class TestCalendarRoll {

  public static void main(String[] args) {
    String DATE_FORMAT = "yyyy-MM-dd";
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance();
    // roll down the month
    c1.set(1999, 0, 20); // 1999 jan 20
    System.out.println("Date is : " + sdf.format(c1.getTime()));
    c1.roll(Calendar.MONTH, false); // roll down, substract 1 month
    // 1999 jan 20
    System.out.println("Date roll down 1 month : " + sdf.format(c1.getTime()));

    c1.set(1999, 0, 20); // 1999 jan 20
    System.out.println("Date is : " + sdf.format(c1.getTime()));
    c1.add(Calendar.MONTH, -1); // substract 1 month
    // 1998 dec 20
    System.out.println("Date minus 1 month : " + sdf.format(c1.getTime()));

  }

}
