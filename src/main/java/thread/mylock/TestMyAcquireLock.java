package thread.mylock;

import java.util.concurrent.locks.Lock;

/**
 * @description
 * @author: jxy
 * @create: 2020-04-22 15:56
 */
public class TestMyAcquireLock {

    public static void main(String[] args) {
        MyAcquireLock lock = new MyAcquireLock();
        Integer integer = 0;
        IntSaveClass intSaveClass = new IntSaveClass();
        new Thread(new RunnableNum(intSaveClass,lock)).start();
        new Thread(new RunnableNum(intSaveClass,lock)).start();
        new Thread(new RunnableNum(intSaveClass,lock)).start();
        new Thread(new RunnableNum(intSaveClass,lock)).start();
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(intSaveClass.getI());
    }

    private static class RunnableNum implements Runnable {

        IntSaveClass intSaveClass;

        Lock lock;

        public RunnableNum(IntSaveClass intSaveClass, Lock lock) {
            this.intSaveClass = intSaveClass;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10000; i++) {
                    intSaveClass.add();
                }
            } finally {
                lock.unlock();
            }

        }
    }

    private static class IntSaveClass {

        int i = 0;

        public void add() {
            i++;
        }

        public int getI() {
            return i;
        }
    }
}
