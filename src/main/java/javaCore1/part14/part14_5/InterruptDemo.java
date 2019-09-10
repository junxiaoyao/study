package javaCore1.part14.part14_5;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-20 15:32
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        // sleepThread睡眠1000ms
        final Thread sleepThread = new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        // busyThread一直执行死循环
        Thread busyThread = new Thread() {

            @Override
            public void run() {
                while (true);
            }
        };
        int s = 5;

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted());
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
