package com.flyong.others.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ObjectRemoveDeterming {

  public static void main(String[] args) {
    // Create the weak reference.
    ReferenceQueue rq = new ReferenceQueue();
    WeakReference wr = new WeakReference("TEST", rq);

    // Wait for all the references to the object.
    try {
      while (true) {
        Reference r = rq.remove();
        if (r == wr) {
          System.out.println("Removed!");
          // Object is no longer referenced.
        }
      }
    } catch (InterruptedException e) {
    }

  }

}
