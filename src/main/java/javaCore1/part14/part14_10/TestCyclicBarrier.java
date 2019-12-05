package javaCore1.part14.part14_10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

//栅栏测试
public class TestCyclicBarrier {

  public static void main(String[] args) throws BrokenBarrierException,InterruptedException{
    final int nThreads=100;
    CyclicBarrier cyclicBarrier=new CyclicBarrier(nThreads);
    for (int i=1;i<nThreads;i++){
      new Thread(new TestCyclicBarrierRunable(cyclicBarrier,i*100,i)).start();
    }
    cyclicBarrier.await();
    System.out.println("i am main thread");
  }
}

class TestCyclicBarrierRunable implements Runnable {

  private CyclicBarrier cyclicBarrier;
  private int sleepTime;
  private int n;

  public TestCyclicBarrierRunable(CyclicBarrier cyclicBarrier, int sleepTime,int n) {
    this.cyclicBarrier = cyclicBarrier;
    this.sleepTime = sleepTime;
    this.n=n;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(sleepTime);
      cyclicBarrier.await();
      System.out.println(" i am "+n);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }catch (BrokenBarrierException b){
      b.printStackTrace();
    }
  }
}
