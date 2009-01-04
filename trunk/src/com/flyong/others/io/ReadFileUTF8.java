package com.flyong.others.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 读取UTF-8编码的文件内容。
 * 
 * 
 * 
 */
public class ReadFileUTF8 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("java2000"),
          "UTF8"));
      String str;
      while ((str = in.readLine()) != null) {
        System.out.println(str);
      }
    } catch (UnsupportedEncodingException e) {
    } catch (IOException e) {
    }

  }
}
