package com.flyong.others.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志测试。
 * 
 *
 * 
 */
public class LoggingTest {
  public static void main(String[] args) {
    // 拿到一个logger,如果不存在则自动创建一个
    Logger log = Logger.getLogger(LoggingTest.class.getName());

    log.setLevel(Level.FINER);
    // 不同的日志等级，显示不同的信息
    log.severe("severe message");
    log.warning("warning message");
    log.info("info message");
    log.config("config message");
    log.fine("fine level one message");
    log.finer("fine level two message");
    log.finest("fine level three message");

    System.out.println(log.getLevel());
    System.out.println(log.isLoggable(Level.FINER));
  }
}
