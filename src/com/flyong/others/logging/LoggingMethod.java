package com.flyong.others.logging;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class LoggingMethod {

  public static void main(String[] args) {
    new LoggingMethod().myMethod(123, 456);

  }

  public boolean myMethod(int p1, Object p2) {
    Logger logger = Logger.getLogger("net.java2000.util.logging");
    java.util.logging.SimpleFormatter formater = new SimpleFormatter();
    StreamHandler ch = new StreamHandler(System.out,formater);
    logger.addHandler(ch);
    logger.setLevel(Level.FINER);
    
    if (logger.isLoggable(Level.FINER)) {
      logger.entering(this.getClass().getName(), "myMethod", new Object[] { new Integer(p1),
          p2 });
    }

    // Method body

    // Log exiting
    boolean result = true;

    if (logger.isLoggable(Level.FINER)) {
      logger.exiting(this.getClass().getName(), "Method", new Boolean(result));

      // If the method does not return a value
      logger.exiting(this.getClass().getName(), "Method");
    }

    return result;
  }
}
