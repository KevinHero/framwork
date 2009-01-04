package com.flyong.others.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 属性变更的侦听
 * 
 * 
 * 
 */
public class BeanChangeListener {
  int myProperty;

  public int getMyProperty() {
    return myProperty;
  }

  public void setMyProperty(int newValue) {
    int oldValue = myProperty;
    myProperty = newValue;
    // 触发属性变更的事件
    pceListeners.firePropertyChange("myProperty", new Integer(oldValue),
        new Integer(newValue));
  }

  // Create the listener list.
  // 创建侦听列表
  PropertyChangeSupport pceListeners = new PropertyChangeSupport(this);

  // The listener list wrapper methods.
  // 侦听器列表的方法
  public synchronized void addPropertyChangeListener(
      PropertyChangeListener listener) {
    pceListeners.addPropertyChangeListener(listener);
  }

  public synchronized void removePropertyChangeListener(
      PropertyChangeListener listener) {
    pceListeners.removePropertyChangeListener(listener);
  }

 /* public static void main(String[] args) {
    BeanChangeListener t = new BeanChangeListener();
    t.addPropertyChangeListener(new PropertyChangeListener() {

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        if ("myProperty".equals(evt.getPropertyName())) {
          System.out.println(evt.getOldValue() + " -> " + evt.getNewValue());
        }
      }

    });
    t.setMyProperty(1000);
  }*/
}
