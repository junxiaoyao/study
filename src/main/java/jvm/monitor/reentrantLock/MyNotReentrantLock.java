package jvm.monitor.reentrantLock;

import java.util.concurrent.locks.LockSupport;

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

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      LockSupport.park();
      System.out.println(Thread.currentThread().getName() + "被唤醒");
    });
    thread.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LockSupport.unpark(thread);
  }
}
