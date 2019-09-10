package jvm.monitor.reentrantLock;

public class MyNotReentrantLock {
  private boolean isLocked = false;
  //同一线程再次请求锁时无法获取导致死锁
  public synchronized void lock() throws InterruptedException{
    while(isLocked){
      wait();
    }
    isLocked = true;
  }
  public synchronized void unlock(){
    isLocked = false;
    notifyAll();
  }
}
