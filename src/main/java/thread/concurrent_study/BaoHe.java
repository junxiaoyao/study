package thread.concurrent_study;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BaoHe {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService= (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
