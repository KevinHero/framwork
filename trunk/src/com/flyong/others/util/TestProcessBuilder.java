package com.flyong.others.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 *
 *
 */
public class TestProcessBuilder {
  public static void main(String args[]) throws Exception {

    ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "dir");
    builder.directory(new File("e:/"));
    Process process = builder.start();
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is, "GBK");
    BufferedReader br = new BufferedReader(isr);
    String line;

    System.out.printf("Output of running %s is:", Arrays.toString(args));

    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

  }

}
