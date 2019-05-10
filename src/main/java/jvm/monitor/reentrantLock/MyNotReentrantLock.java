package jvm.monitor.reentrantLock;

public class MyNotReentrantLock {
  private boolean isLocked = false;
  public synchronized void lock() throws InterruptedException{
    while(isLocked){
      wait();
    }
    isLocked = true;
  }
  public synchronized void unlock(){
    isLocked = false;
    notify();
  }
}
