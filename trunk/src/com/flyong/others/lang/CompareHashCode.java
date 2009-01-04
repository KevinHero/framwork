package com.flyong.others.lang;

import java.io.File;

/**
 * 使用HashCode 进行对象的比较。
 * 
 * 
 * 
 */
public class CompareHashCode {

  public static void main(String[] args) {
    // 三个文件对象，其中前2个文件名相同
    File file1 = new File("a");
    File file2 = new File("a");
    File file3 = new File("b");

    // 得到他们的HashCode
    int hc1 = file1.hashCode();
    int hc2 = file2.hashCode();
    int hc3 = file3.hashCode();

    System.out.println("hc1=" + hc1);
    System.out.println("hc2=" + hc2);
    System.out.println("hc3=" + hc3);

    // hc1=1234416
    // hc2=1234416
    // hc3=1234419

    // 检测2个对象是否相同
    if (hc1 == hc2 && file1.equals(file2)) {
      System.out.println("file1==file2");
    }
    // file1==file2

    // 得到唯一的Hash Code
    int ihc1 = System.identityHashCode(file1);
    int ihc2 = System.identityHashCode(file2);
    int ihc3 = System.identityHashCode(file3);
    System.out.println("ihc1=" + ihc1);
    System.out.println("ihc2=" + ihc2);
    System.out.println("ihc3=" + ihc3);

    // ihc1=14576877
    // ihc2=12677476
    // ihc3=33263331
  }
}
