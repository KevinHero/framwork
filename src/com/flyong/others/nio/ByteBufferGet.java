package com.flyong.others.nio;

import java.nio.ByteBuffer;

/**
 * 读取ByteBuffer的数据。
 * 
 * 
 * 
 */
public class ByteBufferGet {

  public static void main(String[] args) {
    // Create an empty ByteBuffer with a 10 byte capacity
    // 创建新的空的ByteBuffer,容量为10字节
    ByteBuffer bbuf = ByteBuffer.allocate(10);

    // Get the ByteBuffer's capacity
    // 得到容量
    int capacity = bbuf.capacity(); // 10

    // Use the absolute get().
    // This method does not affect the position.
    // 绝对读取，得到某个位置的数据，并不影响当前的位置
    byte b = bbuf.get(5); // position=0

    // Set the position
    // 设置位置
    bbuf.position(5);

    // Use the relative get()
    // 相对读取当前位置的数据
    b = bbuf.get();

    // Get the new position
    // 获得新的位置
    int pos = bbuf.position(); // 6

    // Get remaining byte count
    // 获得剩余的字节数量
    int rem = bbuf.remaining(); // 4

    // Set the limit
    // 设置容量限制
    bbuf.limit(7); // remaining=1

    // This convenience method sets the position to 0
    // 复位，位置设置为0
    bbuf.rewind(); // remaining=7

  }

}
