package com.flyong.others.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 

 *
 */
public class TestRuntime {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec("cmd /c dir",null,new File("e:/"));
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is,"GBK");
    BufferedReader br = new BufferedReader(isr);
    String line;

    System.out.printf("Output of running %s is:", Arrays.toString(args));

    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
  }

}
