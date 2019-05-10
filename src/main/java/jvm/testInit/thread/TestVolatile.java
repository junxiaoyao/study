package jvm.testInit.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class TestVolatile {
  static AtomicInteger integer=new AtomicInteger(0);
  public static volatile int count = 0;

  public static void main(String[] args) {
    //AtomicStampedReference
       // RuntimeException
   // ReentrantLock
    for (int i = 0; i < 10; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 5000; i++) {
            count++;
            integer.incrementAndGet();
          }
        }
      }).start();
    }
    while (Thread.activeCount()>1)
      Thread.yield();
    System.out.println(integer.get());
    System.out.println(count);
  }
}
