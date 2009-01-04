package com.flyong.others.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer多个任务的例子。
 * 
 * 
 * 
 */
public class TimeTestMulti {
  public static void main(String[] args) {
    final Timer timer = new Timer();

    // 任务1， 每一秒执行一次
    timer.schedule(new TimerTask() {
      public void run() {
        System.out.println("I am running 1 ...");
      }
    }, 0, 1000);
    // 任务2，每0.5秒执行一次
    timer.schedule(new TimerTask() {
      public void run() {
        System.out.println("I am running 2 ...");
      }
    }, 0, 500);
  }
}
