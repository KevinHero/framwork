package com.flyong.test;

public class UserNotFoundException extends Exception {

  private Throwable nestedThrowable = null;

  public UserNotFoundException() {

    super();

  }

  public UserNotFoundException(String msg) {

    super(msg);

  }

}