package com.flyong.others.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateWeek {
  public static void main(String[] args) {
    GregorianCalendar newCal = new GregorianCalendar();
    System.out.println("DAY_OF_WEEK=" + newCal.get(Calendar.DAY_OF_WEEK));
    newCal = new GregorianCalendar();
    newCal.set(2008, 9, 14, 0, 0, 0);
    newCal.setTime(newCal.getTime());
    System.out.println("DAY_OF_WEEK=" + newCal.get(Calendar.DAY_OF_WEEK));
    System.out.println("DAY_OF_MONTH=" + newCal.get(Calendar.DAY_OF_MONTH));
    System.out.println("DAY_OF_WEEK_IN_MONTH=" + newCal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    System.out.println("DAY_OF_YEAR=" + newCal.get(Calendar.DAY_OF_YEAR));
    System.out.println("DATE=" + newCal.get(Calendar.DATE));

  }
}
