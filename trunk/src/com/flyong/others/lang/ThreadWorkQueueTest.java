package com.flyong.others.lang;

import java.util.LinkedList;

/**
 * 工作队列和多个工人的多线程调度。
 * 
 * 
 * 
 */
public class ThreadWorkQueueTest {

  public static void main(String[] args) {
    // 创建工作队列
    ThreadWorkQueue queue = new ThreadWorkQueue();

    // 创建多个工人线程
    final int numWorkers = 10;
    ThreadWorker[] workers = new ThreadWorker[numWorkers];
    for (int i = 0; i < workers.length; i++) {
      workers[i] = new ThreadWorker(queue);
      workers[i].start();
    }

    // 在工作队列里面增加一些工作
    for (int i = 0; i < 30; i++) {
      queue.addWork(i);
    }

    // 增加一些终止工人工作的标志
    for (int i = 0; i < workers.length; i++) {
      queue.addWork(ThreadWorker.NO_MORE_WORK);
    }

  }

}

/**
 * 工作队列。
 * 
 * 
 * 
 */
class ThreadWorkQueue {
  LinkedList<Object> queue = new LinkedList<Object>();

  // 在工作队列里增加工作
  public synchronized void addWork(Object o) {
    queue.addLast(o);
    // 通知
    notify();
  }

  // 从工作队列里获得下一个工作，如果没有则等待。
  public synchronized Object getWork() throws InterruptedException {
    while (queue.isEmpty()) {
      wait();
    }
    return queue.removeFirst();
  }
}

/**
 * 工人。
 * 
 * 
 * 
 */
class ThreadWorker extends Thread {
  // 工作结束的标志。
  static final Object NO_MORE_WORK = new Object();

  ThreadWorkQueue q;

  ThreadWorker(ThreadWorkQueue q) {
    this.q = q;
  }

  public void run() {
    try {
      while (true) {
        // 从工作队列获取工作
        Object x = q.getWork();

        // 如果是终止标志，则退出循环
        if (x == NO_MORE_WORK) {
          break;
        }

        // Compute the square of x
        // 一些任务
        System.out.println(x);
      }
    } catch (InterruptedException e) {
    }
  }
}
