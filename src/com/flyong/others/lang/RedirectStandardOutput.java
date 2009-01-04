package com.flyong.others.lang;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 替换标准输出为自定义的。
 * 
 * 
 * 
 */
public class RedirectStandardOutput {

  public static void main(String[] args) {
    try {
      // 替换标准输出
      PrintStream out = new PrintStream(new FileOutputStream("out.log"));
      PrintStream tee = new TeeStream(System.out, out);

      System.setOut(tee);

      // 替换标准错误输出
      PrintStream err = new PrintStream(new FileOutputStream("err.log"));
      tee = new TeeStream(System.err, err);

      System.setErr(tee);
    } catch (FileNotFoundException e) {
    }

    // 输出测试
    System.out.println("welcome");
    System.err.println("error");

  }

}

/**
 * 新的输出类。同时处理2个输出流
 * 
 * 
 * 
 */
class TeeStream extends PrintStream {
  PrintStream out;

  public TeeStream(PrintStream out1, PrintStream out2) {
    super(out1);
    this.out = out2;
  }

  public void write(byte buf[], int off, int len) {
    try {
      super.write(buf, off, len);
      out.write(buf, off, len);
    } catch (Exception e) {
    }
  }

  public void flush() {
    super.flush();
    out.flush();
  }
}
