package com.flyong.others.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
  public static void main(String args[]) {
    // Create a set
    Set set = new HashSet();

    // Add some elements to the set
    set.add("a");
    set.add("b");
    set.add("c");
    
    set.add("c");

    // Remove elements from the set
    set.remove("c");

    // Retrieve number of elements in the set
    int size = set.size(); // 2

    // Adding an element that already exists has no effect
    set.add("a");
    size = set.size(); // 2

    // Identifying the presence of an element in the set
    boolean b = set.contains("a"); // true
    b = set.contains("c"); // false

    // Iterating over the elements in the set
    Iterator it = set.iterator();
    while (it.hasNext()) {
      // Get element
      Object element = it.next();
    }

    // Create an array (ex. string) of all elements in the set
    String[] array = (String[]) set.toArray(new String[set.size()]);
  }
}
