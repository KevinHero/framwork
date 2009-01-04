package com.flyong.others.applet;

import java.applet.*;
import java.awt.*;

/**
 * Applet的基础框架。
 * 
 * 
 * 
 */
public class BasicApplet extends Applet {
  /**
   * 
   */
  private static final long serialVersionUID = 3363561144082703501L;

  // This method is called once by the browser when it starts the applet.
  // 浏览器第一次启动这个applet时被调用一次
  public void init() {
  }

  // This method is called whenever the page containing this applet is made
  // visible.
  // 当包含这个applet的页面可见时，被调用
  public void start() {
  }

  // This method is called whenever the page containing this applet is not
  // visible.
  // 当包含这个applet的页面不可见时被调用
  public void stop() {
  }

  // This method is called once when the browser destroys this applet.
  // 当浏览器销毁这个applet时被调用
  public void destroy() {
  }

  // This method is called whenever this applet needs to repaint itself.
  // 当applet需要自己重画时被调用
  public void paint(Graphics g) {


  }
}
