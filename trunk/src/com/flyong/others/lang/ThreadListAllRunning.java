package com.flyong.others.lang;

/**
 * 列出所有运行中的线程。
 * 
 * 
 */
public class ThreadListAllRunning {

  public static void main(String[] args) {
    // 拿到最顶层的线程组
    ThreadGroup root = Thread.currentThread().getThreadGroup();
    while (root.getParent() != null) {
      root = root.getParent();
    }

    // 访问每一个组
    visit(root, 0);
  }

  /**
   * 此方法递归调用指定组下面的所有下属组。
   * 
   * @param group
   *          指定的组
   * @param level
   *          层数
   */
  public static void visit(ThreadGroup group, int level) {
    // 得到当前组的活跃线程
    int numThreads = group.activeCount();
    Thread[] threads = new Thread[numThreads * 2];
    numThreads = group.enumerate(threads, false);

    // 循环每个线程
    for (int i = 0; i < numThreads; i++) {
      // 得到线程
      Thread thread = threads[i];
      System.out.println(thread);
    }

    // 得到当前组的所有下属子组
    int numGroups = group.activeGroupCount();
    ThreadGroup[] groups = new ThreadGroup[numGroups * 2];
    numGroups = group.enumerate(groups, false);

    // 递归调用每个子组
    for (int i = 0; i < numGroups; i++) {
      visit(groups[i], level + 1);
    }
  }
}
