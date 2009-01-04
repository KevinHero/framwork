package com.flyong.others.swing;

import javax.swing.JOptionPane;

public class JOptionpaneTest {
  public static void main(String args[]) {
    String number, Output;
    int n;
    int s = 0;
    number = JOptionPane.showInputDialog("Enter a Number：");

    n = Integer.parseInt(number);

    for (int i = 1; i <= n; i++) {
      s += i;
    }

    JOptionPane.showMessageDialog(null, null,""+s, JOptionPane.PLAIN_MESSAGE);
    System.out.println("S=" + s);

    System.exit(0);
  }
}