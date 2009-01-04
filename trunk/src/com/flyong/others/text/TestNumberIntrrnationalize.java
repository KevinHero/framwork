package com.flyong.others.text;

import java.text.DecimalFormat;
import java.util.Locale;

public class TestNumberIntrrnationalize {

  public static void main(String[] args) {
    DecimalFormat nf = (DecimalFormat) DecimalFormat.getInstance(Locale.GERMAN);

    System.out.println(nf.format(12345.45)); // 12.345,45
    
  }

}
