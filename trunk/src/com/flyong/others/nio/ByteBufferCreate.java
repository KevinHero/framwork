package com.flyong.others.nio;

import java.nio.ByteBuffer;

/**
 * 几种创建ByteBuffer的方法。
 * 
 *
 * 
 */
public class ByteBufferCreate {

  public static void main(String[] args) {
    // 使用byte数组创建
    byte[] bytes = new byte[10];
    ByteBuffer buf = ByteBuffer.wrap(bytes);

    // 创建一个非直接的ByteBuffer,内部用byte数组保存
    buf = ByteBuffer.allocate(10);

    // 创建一个直接(内存映射)ButeBuffer
    buf = ByteBuffer.allocateDirect(10);
  }
}
