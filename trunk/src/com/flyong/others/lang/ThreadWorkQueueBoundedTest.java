package com.flyong.others.lang;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * JDK 5.0开始的，支持容量限制和阻塞功能的队列。
 * 
 * 
 * 
 */
public class ThreadWorkQueueBoundedTest {

  public static void main(String[] args) {
    // 创建一个带容量限制的，阻塞功能的队列
    final int capacity = 10;
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(capacity);

    // 创建工人
    final int numWorkers = 10;
    ThreadWorkerBounded[] workers = new ThreadWorkerBounded[numWorkers];
    for (int i = 0; i < workers.length; i++) {
      workers[i] = new ThreadWorkerBounded(queue);
      workers[i].start();
    }

    try {
      // 增加工作，如果当前的队列已满，会阻塞，直到工作队列有空余的位子
      for (int i = 0; i < 30; i++) {
        queue.put(i);
      }

      // 增加结束标志
      for (int i = 0; i < workers.length; i++) {
        queue.put(ThreadWorkerBounded.NO_MORE_WORK);
      }
    } catch (InterruptedException e) {
    }

  }

}

/**
 * 阻塞队列的工人。
 * 
 * 
 * 
 */
class ThreadWorkerBounded extends Thread {
  // 工作结束标志
  static final Integer NO_MORE_WORK = new Integer(0);

  BlockingQueue<Integer> q;

  ThreadWorkerBounded(BlockingQueue<Integer> q) {
    this.q = q;
  }

  public void run() {
    try {
      while (true) {
        // 获取下一个工作，如果队列为空，则阻塞等待
        Integer x = q.take();

        // 如果是结束标志，则退出循环
        if (x == NO_MORE_WORK) {
          break;
        }

        // 对返回值进行操作
        System.out.println(x);
      }
    } catch (InterruptedException e) {
    }
  }
}
