package com.flyong.others.lang;

/**
 * 异常信息的跟踪。
 * 
 * 
 * 
 */
public class ExceptionStackTrace {

  private static void testException() throws Exception {
    int i = 1 / 0;
  }

  public static void main(String[] args) {
    try {
      testException();
    } catch (Throwable e) {
      // 得到异常的堆栈
      StackTraceElement stack[] = e.getStackTrace();

      // stack[0] 包含了引发异常的那个方法
      // stack[stack.length-1] 包含了更原始的方法调用。
      for (int i = 0; i < stack.length; i++) {
        String filename = stack[i].getFileName();
        if (filename == null) {
          System.out.println("没有找到异常对应的文件名");
        } else {
          System.out.println(filename);
        }
        String className = stack[i].getClassName();
        System.out.println("类名=" + className);
        String methodName = stack[i].getMethodName();
        System.out.println("方法名=" + methodName);
        boolean isNativeMethod = stack[i].isNativeMethod();
        System.out.println("是否为本地(Native)方法=" + isNativeMethod);
        int line = stack[i].getLineNumber();
        System.out.println("行数=" + line);
        System.out.println("----------------------");
      }
    }

  }
}
