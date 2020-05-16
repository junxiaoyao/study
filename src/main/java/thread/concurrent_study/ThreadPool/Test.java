package thread.concurrent_study.ThreadPool;

import java.util.concurrent.*;

/**
 * @author jxy
 * @className Test
 * @description 描述
 * @date 2020/5/16 19:59
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue=new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor executor=new MyThreadPoolExecutor(
                1,
                10,
                10,
                TimeUnit.SECONDS,
                blockingQueue,
                new MyThreadFactory("test自定义线程池"),
                new ThreadPoolExecutor.AbortPolicy()
                );
        for (int i=0;i<15;i++){
            executor.execute(new RunnableTestMyThreadFactory());
        }
        while (Thread.activeCount()>1){
            //提醒JvmGc引起，被移除线程池的线程回收
            System.gc();
            Thread.yield();
        }
    }
}
class RunnableTestMyThreadFactory implements Runnable{
    @Override
    public void run() {
        try {
                Thread.sleep(5000);
                System.out.println("执行线程："+Thread.currentThread().getName());
                int randomNum=(int)(Math.random()*10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
