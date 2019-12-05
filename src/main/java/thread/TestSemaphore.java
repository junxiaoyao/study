package thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-22 16:19 信号量 控制同时访问资源的线程个数
 */
public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        init(semaphore);
    }

    public static void init(Semaphore semaphore) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "尝试获取到资源");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取到资源");
                    Thread.sleep(5000);
                } catch (Exception e) {

                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放资源");
                }
            }).start();
        }
    }
}
