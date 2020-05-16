package thread.concurrent_study.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author jxy
 * @className MyThreadPoolExecutor
 * @description 描述
 * @date 2020/5/16 20:46
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {
    private final ThreadLocal<Long> startTime=new ThreadLocal<>();
    private final Logger log=Logger.getAnonymousLogger();
    private final AtomicLong numTasks=new AtomicLong();
    private final AtomicLong totalTime=new AtomicLong();

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        log.fine(String.format("Thread %s : start %s",t,r));
        startTime.set(System.nanoTime());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime=System.nanoTime();
            long taskTime=endTime-startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            log.fine(String.format("Thread %s : end %s,time=%dns ",t,r,taskTime));
            startTime.set(System.nanoTime());
        }finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try{
            log.info(String.format("terminated: avg time=%dns ",totalTime.get()/numTasks.get()));
        }finally {
            super.terminated();
        }

    }
}
