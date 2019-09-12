package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 记录线程池某线程执行任务数量
 * @author: jxy
 * @create: 2019-09-12 11:07
 */
public class TestThreadPoolUse {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(6);
        Map<String, Integer> map = new ConcurrentHashMap<>();
        final int COUNT = 10;
        CountDownLatch latch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            service.execute(new TestRunnable(map, latch));
        }
        latch.await();
        service.shutdown();
        System.out.println();
    }
}

class TestRunnable implements Runnable {

    Map<String, Integer> map;

    CountDownLatch latch;

    public TestRunnable(Map<String, Integer> map, CountDownLatch latch) {
        this.map = map;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            String key = Thread.currentThread().getId() + "";
            Integer integer = map.get(key);
            if (integer != null) {
                map.put(key, new Integer(integer + 1));
            } else {
                map.put(key, 1);
            }
        } catch (Exception e) {

        } finally {
            latch.countDown();
        }

    }
}