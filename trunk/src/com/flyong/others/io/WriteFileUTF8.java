package com.flyong.others.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * 写入UTF-8编码的数据。
 * 
 * 
 * 
 */
public class WriteFileUTF8 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("java2000"),
          "UTF8"));
      out.write("JAVA,f.net");
      out.close();
    } catch (UnsupportedEncodingException e) {
    } catch (IOException e) {
    }

  }

}
