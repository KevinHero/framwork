package com.flyong.others.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDatetime {

  /**
   * @param args
   */
  public static void main(String[] args) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
  }

}
