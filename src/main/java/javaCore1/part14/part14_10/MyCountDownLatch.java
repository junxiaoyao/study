package javaCore1.part14.part14_10;

public class MyCountDownLatch {

  private int count;

  public MyCountDownLatch(int count) {
    this.count = count;
  }

  public synchronized void await() throws InterruptedException {
    while (count > 0) {
      wait();
    }
  }

  public synchronized void down() throws InterruptedException {
    count--;
    notifyAll();
  }
}
