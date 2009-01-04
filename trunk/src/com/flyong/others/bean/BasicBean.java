package com.flyong.others.bean;

import java.io.Serializable;

/**
 * 标准Bean的格式.
 * 
 * 
 * 
 */
public class BasicBean implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -4457133624004864499L;
  boolean property;

  public BasicBean() {
  }

  public boolean getProperty() {
    return property;
  }

  public boolean isProperty() {
    return property;
  }

  public void setProperty(boolean newValue) {
    property = newValue;
  }

}
