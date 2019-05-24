package javaCore1.part14.part14_10;

public class TestVolatile {

  public static void main(String[] args) throws InterruptedException {
    final int nThreads=100;
    MyCountDownLatch countDownLatch = new MyCountDownLatch(nThreads);
    TestCount testCount=new TestCount();
    for (int i=0;i<nThreads;i++) {
      TestVolatileRunable runable = new TestVolatileRunable(countDownLatch, testCount);
      new Thread(runable).start();
    }
    countDownLatch.await();
    System.out.println(testCount.getCount());
  }
}

class TestCount {

  private volatile int count;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  public void countAdd(){
    this.count++;
  }
}

class TestVolatileRunable implements Runnable {

  private MyCountDownLatch countDownLatch;
  private TestCount testCount;

  public TestVolatileRunable(MyCountDownLatch countDownLatch,
      TestCount testCount) {
    this.countDownLatch = countDownLatch;
    this.testCount = testCount;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 1000; i++) {
          testCount.countAdd();
      }
      countDownLatch.down();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
 class Test {
  public volatile int inc = 0;

  public void increase() {
    inc++;
  }

  public static void main(String[] args) {
    final Test test = new Test();
    for(int i=0;i<10;i++){
      new Thread(){
        public void run() {
          for(int j=0;j<1000;j++)
            test.increase();
        }
      }.start();
    }

    while(Thread.activeCount()>1)  //保证前面的线程都执行完
      Thread.yield();
    System.out.println(test.inc);
  }
}