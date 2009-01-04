package com.flyong.others.util;

import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
  public static void main(String[] args) {
    int interval = 2000; // 10 sec
    Date timeToRun = new Date(System.currentTimeMillis() + interval);
    final Timer timer = new Timer();

    timer.schedule(new TimerTask() {
      public void run() {
        // Task here ...
        System.out.println("I am running...");
        // 终止
        timer.cancel();
      }
    }, timeToRun);

  }
}
