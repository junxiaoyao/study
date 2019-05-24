package javaCore1.part14.part14_10;

import java.util.concurrent.CountDownLatch;

public class TestMyCountDownLatch {

  public static void main(String[] args)throws InterruptedException {
    final int nThreads=100;
    MyCountDownLatch countDownLatch=new MyCountDownLatch(nThreads);
    for (int i=0;i<nThreads;i++){
      new Thread(new TestMyCountDownLatchRunable(countDownLatch,i*100)).start();
    }
    countDownLatch.await();
    System.out.println("i am main thread");
  }
}

class TestMyCountDownLatchRunable implements Runnable {
  private MyCountDownLatch myCountDownLatch;
  private int sleepTime;

  public TestMyCountDownLatchRunable(MyCountDownLatch myCountDownLatch, int sleepTime) {
    this.myCountDownLatch = myCountDownLatch;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(sleepTime);
      myCountDownLatch.down();
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
