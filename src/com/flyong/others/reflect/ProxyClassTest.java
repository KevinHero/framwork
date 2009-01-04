package com.flyong.others.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个接口
 * 
 *
 * 
 */
interface MyInterface {
  void method();
}

/**
 * 接口的实现
 * 
 * 
 * 
 */
class MyInterfaceImpl implements MyInterface {
  public void method() {
    System.out.println("MyInterfaceImpl");
  }
}

/**
 * 代理类
 * 
 * 
 * 
 */

class ProxyClass implements InvocationHandler {
  Object obj;

  public ProxyClass(Object o) {
    obj = o;
  }

  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Object result = null;
    try {
      result = m.invoke(obj, args);
      System.out.println(result);
    } catch (InvocationTargetException e) {
    } catch (Exception eBj) {
    } finally {
    }
    return result;
  }
}

/**
 * 代理测试类
 * 
 * 
 * 
 */
public class ProxyClassTest {
  public static void main(String[] args) {
    // 创建一个代理类
    MyInterface myintf = (MyInterface) Proxy.newProxyInstance(MyInterface.class
        .getClassLoader(), new Class[] { MyInterface.class }, new ProxyClass(
        new MyInterfaceImpl()));

    // 调用这个方法
    myintf.method();

  }
}
