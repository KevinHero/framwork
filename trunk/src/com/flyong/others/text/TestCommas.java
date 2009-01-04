package com.flyong.others.text;

import java.text.DecimalFormat;

public class TestCommas {

  public static void main(String[] args) {
    double d = 123456789123456.78;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    System.out.println(df.format(d));
  }

}
