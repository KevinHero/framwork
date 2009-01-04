package com.flyong.threadpool;
import java.util.logging.Level;
import java.util.logging.Logger;

class T {
  public static void main(String[] args) {
    new T().myMethod(1, 2);
  }

  public boolean myMethod(int p1, Object p2) {
    // Log object entry
    Logger logger = Logger.getLogger("");
    if (logger.isLoggable(Level.FINER)) {
      logger.entering(this.getClass().getName(), "Method",
          new Object[] { new Integer(p1), p2 });
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