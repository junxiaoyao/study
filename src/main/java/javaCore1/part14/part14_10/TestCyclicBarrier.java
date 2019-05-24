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
      new Thread(new TestCyclicBarrierRunable(cyclicBarrier,i*100)).start();
    }
    cyclicBarrier.await();
    System.out.println("i am main thread");
  }
}

class TestCyclicBarrierRunable implements Runnable {

  private CyclicBarrier cyclicBarrier;
  private int sleelTime;

  public TestCyclicBarrierRunable(CyclicBarrier cyclicBarrier, int sleelTime) {
    this.cyclicBarrier = cyclicBarrier;
    this.sleelTime = sleelTime;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(sleelTime);
      cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }catch (BrokenBarrierException b){
      b.printStackTrace();
    }
  }
}
