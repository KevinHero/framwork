package com.flyong.others.lang;

/**
 * 系统内存堆的数据。
 * 
 * 
 * 
 */
public class HeapMemorySize {

  public static void main(String[] args) {
    // 得到当前的堆大小(字节)
    long heapSize = Runtime.getRuntime().totalMemory();
    System.out.println("totalMemory=" + heapSize);

    // 得到堆的最大尺寸(字节)。不能超过这个尺寸
    // 任何可能超过这个尺寸的操作都将引发 OutOfMemoryException.
    long heapMaxSize = Runtime.getRuntime().maxMemory();
    System.out.println("maxMemory=" + heapMaxSize);

    // 得到可用的堆空间(字节),在垃圾回收后会增加，在分配新的对象后减少
    long heapFreeSize = Runtime.getRuntime().freeMemory();
    System.out.println("freeMemory=" + heapFreeSize);
  }
}
