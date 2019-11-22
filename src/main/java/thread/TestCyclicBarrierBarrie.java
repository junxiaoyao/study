package thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-22 10:36
 * CyclicBarrier 可以循环利用
 */
public class TestCyclicBarrierBarrie {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        init(cyclicBarrier);

        try {
            Thread.sleep(5000);
            System.out.println("-------------------------------------------");
            init(cyclicBarrier);
        } catch (Exception e) {

        }

    }
    public static void init(CyclicBarrier barrier){
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "到达等待点");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "越过等待点");
                } catch (Exception e) {

                }
            }).start();
        }
    }
}
