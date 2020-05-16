package thread.concurrent_study.ThreadPool;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class MyAppThread extends Thread {
    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = true;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private final AtomicInteger executeTaskNums=new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable runnable) {
        this(runnable, DEFAULT_NAME);
    }

    public MyAppThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
    }

    @Override
    public void run() {
        //复制debug标志，确保一致的值
        boolean debug = debugLifecycle;
        if (debug) log.log(Level.INFO, "Created" + getName());
        try {
            alive.incrementAndGet();
            executeTaskNums.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug){
                log.log(Level.INFO, "Exiting" + getName());
            }
            log.log(Level.INFO,getName()+"执行任务数量："+executeTaskNums.get());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        log.log(Level.INFO,getName()+"最终执行任务数量："+executeTaskNums.get());
        super.finalize();
    }
}
