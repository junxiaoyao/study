package javaCore1.part14.part14_5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

  public static void main(String[] args) {
    TestLockClass testLockClass = new TestLockClass();
    new Thread(new RunA(testLockClass)).start();
    new Thread(new RunB(testLockClass)).start();
  }
}

class RunA implements Runnable {

  private TestLockClass testLockClass;

  public RunA(TestLockClass testLockClass) {
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

class RunB implements Runnable {

  private TestLockClass testLockClass;

  public RunB(TestLockClass testLockClass) {
    this.testLockClass = testLockClass;
  }

  @Override
  public void run() {
    testLockClass.show();
  }
}

class TestLockClass {

  private Lock lock;
  private Condition condition;
  private int size;

  public TestLockClass() {
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
      lock.unlock();
    }
    // }
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    lock.lock();
    try {
      this.size = size;
      //唤醒等待的线程，
      //但必须当前线程释放锁，
      //等待线程方有机会获取锁，
      //并接着执行等待后
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}