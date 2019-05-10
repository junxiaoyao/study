package jvm.monitor.reentrantLock;

public class MyNotReentTest {

  MyNotReentrantLock lock = new MyNotReentrantLock();

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
    MyNotReentTest test=new MyNotReentTest();
    test.print();
  }
}
