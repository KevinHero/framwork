package com.flyong.others.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 得到某月的最大天数。
 * 
 * 
 * 
 */
public class CalendarMaxDayOfMonth {

  public static int daysInMonth(GregorianCalendar c) {
    int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    daysInMonths[1] += c.isLeapYear(c.get(GregorianCalendar.YEAR)) ? 1 : 0;
    return daysInMonths[c.get(GregorianCalendar.MONTH)];
  }

  public static void main(String[] args) {
    GregorianCalendar c = new GregorianCalendar();
    System.out.println(daysInMonth(c));
    System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
  }

}
