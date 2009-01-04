package com.flyong.others.bean;

import java.beans.Beans;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.IOException;

public class BeanVetoableChange {
  int myProperty;

  public int getMyProperty() {
    return myProperty;
  }

  public void setMyProperty(int newValue) throws PropertyVetoException {
    try {
      vceListeners.fireVetoableChange("myProperty", new Integer(myProperty),
          new Integer(newValue));
      myProperty = newValue;
    } catch (PropertyVetoException e) {
      throw e;
    }
  }

  // Create the listener list.
  VetoableChangeSupport vceListeners = new VetoableChangeSupport(this);

  // The listener list wrapper methods.
  public synchronized void addVetoableChangeListener(
      VetoableChangeListener listener) {
    vceListeners.addVetoableChangeListener(listener);
  }

  public synchronized void removeVetoableChangeListener(
      VetoableChangeListener listener) {
    vceListeners.removeVetoableChangeListener(listener);
  }

  /*public static void main(String[] args) throws Exception {
    BeanVetoableChange t = (BeanVetoableChange) Beans.instantiate(ClassLoader
        .getSystemClassLoader(), "BeanVetoableChange");

    t.addVetoableChangeListener(new VetoableChangeListener() {

      @Override
      public void vetoableChange(PropertyChangeEvent evt)
          throws PropertyVetoException {
        if ("myProperty".equals(evt.getPropertyName())) {
          System.out.println(evt.getOldValue() + " -> " + evt.getNewValue());
          if (((Integer) evt.getNewValue()) < 0) {
            throw new PropertyVetoException("不能小于0", evt);
          }
        }
      }

    });
    t.setMyProperty(1000);
    t.setMyProperty(-1000);
  }*/
}
