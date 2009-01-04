package com.flyong.others.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestScientific {

  public static void main(String args[]) {
    new TestScientific().doit();
  }

  public void doit() {
    NumberFormat formatter = new DecimalFormat();

    int maxinteger = Integer.MAX_VALUE;
    System.out.println(maxinteger); // 2147483647

    formatter = new DecimalFormat("0.######E0");
    System.out.println(formatter.format(maxinteger)); // 2,147484E9

    formatter = new DecimalFormat("0.#####E0");
    System.out.println(formatter.format(maxinteger)); // 2.14748E9

    int mininteger = Integer.MIN_VALUE;
    System.out.println(mininteger); // -2147483648

    formatter = new DecimalFormat("0.######E0");
    System.out.println(formatter.format(mininteger)); // -2.147484E9

    formatter = new DecimalFormat("0.#####E0");
    System.out.println(formatter.format(mininteger)); // -2.14748E9

    double d = 0.12345;
    formatter = new DecimalFormat("0.#####E0");
    System.out.println(formatter.format(d)); // 1.2345E-1

    formatter = new DecimalFormat("000000E0");
    System.out.println(formatter.format(d)); // 12345E-6
  }
}