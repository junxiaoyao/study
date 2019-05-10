package jvm.monitor.reentrantLock;

public class MyReentrantLockTest {
  MyReentrantLock lock = new MyReentrantLock();

  public void print() throws InterruptedException {
    lock.lock();
    doAdd();
    lock.unlock();
  }

  public void doAdd() throws InterruptedException {
    lock.lock();
    //do something
    lock.unlock();
  }

  public static void main(String[] args) throws InterruptedException{
    MyReentrantLockTest test=new MyReentrantLockTest();
    test.print();
  }
}
