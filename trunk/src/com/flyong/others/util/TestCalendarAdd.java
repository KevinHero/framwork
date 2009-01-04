package com.flyong.others.util;

import java.util.Calendar;

public class TestCalendarAdd {

  public static void main(String[] args) {
    String DATE_FORMAT = "yyyy-MM-dd";
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance();
    c1.set(2008, 9, 14); // 2008-09-14
    System.out.println("Date is : " + sdf.format(c1.getTime()));
    c1.add(Calendar.DATE, 20);
    // Date + 20 days is : 2008-11-03
    System.out.println("Date + 20 days is : " + sdf.format(c1.getTime()));

    
  }

}
