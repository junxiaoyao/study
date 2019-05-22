package javaCore1.part14.part14_5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestUnlock {

  public static void main(String[] args) {
    TestLockClass1 testLockClass = new TestLockClass1();
    new Thread(new RunA1(testLockClass)).start();
    new Thread(new RunB1(testLockClass)).start();
  }
}

class RunA1 implements Runnable {

  private TestLockClass1 testLockClass;

  public RunA1(TestLockClass1 testLockClass) {
    this.testLockClass = testLockClass;
  }

  @Override
  public void run() {
    /**
     *     int size=(int) (Math.random() * 60);
     *     while (size<50) {
     *       size=(int) (Math.random() * 60);
     *     }
     *     testLockClass.setSize(size);
     */
    while (true) {
      testLockClass.setSize((int) (Math.random() * 60));
    }
  }
}

class RunB1 implements Runnable {

  private TestLockClass1 testLockClass;

  public RunB1(TestLockClass1 testLockClass) {
    this.testLockClass = testLockClass;
  }

  @Override
  public void run() {
    testLockClass.show();
  }
}

class TestLockClass1 {

  private Lock lock;
  private Condition condition;
  private int size;

  public TestLockClass1() {
    lock = new ReentrantLock();
    condition = lock.newCondition();
  }

  public void show() {
    //  while (true) {
    lock.lock();
    try {
      while (size < 50) {
        System.out.println("我要等待了，当前size:" + size);
        //该线程会放弃当前锁进入等待，
        // 其他线程此时可以获得锁对象，
        // 并可以唤醒该线程
        condition.await();
      }
      System.out.println("我解锁了,size:" + size);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      //lock.unlock();
    }
    // }
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
    lock.unlock();
  }
}
