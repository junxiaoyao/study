package thread.concurrent_study.aqs_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 闭锁：一种同步工具类，可以延迟线程进度直到起到达终止状态。
 * 在闭锁到达终止态之前，阻塞所有通过线程，之后运行所有线程通过
 * 常见闭锁 CountDownLatch
 */
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        //获取失败会将线程放入等待队列
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            //如果当前闭锁是开放状态，该操作将成功，否则将失败
            return (getState() == 1) ? 1 : -1;
        }

        //有释放直接设置为1，即到达终止态
        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);//打开闭锁，运行通过
            return true;//其他线程可以获取改闭锁
        }

    }

    public static void main(String[] args)throws InterruptedException {
        OneShotLatch oneShotLatch=new OneShotLatch();
        RunnableTestOneShotLatch r=new RunnableTestOneShotLatch(oneShotLatch);
        new Thread(r).start();
        oneShotLatch.await();
        System.out.println("------------主线程结束------------");
    }
}

class RunnableTestOneShotLatch implements Runnable{
    private OneShotLatch latch;

    public RunnableTestOneShotLatch(OneShotLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }finally {
            latch.signal();
        }
    }
}