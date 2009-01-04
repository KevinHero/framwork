package com.flyong.others.io;

import java.io.Serializable;

/**
 * 对于单例对象的反序列化。<br>
 * 一般的反序列化会重新生成一个新的对象，这个方法避免了这个情况，只返回唯一的一个单例对象。
 * 
 * 
 * 
 */
public class MySingleton implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 7458443553836729724L;

  static MySingleton singleton = new MySingleton();

  private MySingleton() {
  }

  // 这个方法在对象被反序列化后被立即调用，他返回了单例的实例。
  protected Object readResolve() {
    return singleton;
  }
}
