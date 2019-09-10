package jvm.monitor.reentrantLock;

/**
 * @description
 * @author: jxy
 * @create: 2019-09-10 14:52
 */
public class TestMyLockRunble implements Runnable {

    private CountTest countTest;

    public TestMyLockRunble(CountTest countTest) {
        this.countTest = countTest;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            countTest.increase();
        }
    }

    public static void main(String[] args) {
        MyReentrantLock lock = new MyReentrantLock();
        CountTest countTest = new CountTest(lock);
        new Thread(new TestMyLockRunble(countTest)).start();
        new Thread(new TestMyLockRunble(countTest)).start();
        new Thread(new TestMyLockRunble(countTest)).start();
        new Thread(new TestMyLockRunble(countTest)).start();
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(countTest.getCount());
    }
}

class CountTest {

    private MyReentrantLock lock;

    private int count;

    public CountTest(MyReentrantLock lock) {
        this.lock = lock;
    }
    //使用自定义的lock锁
    public void increase() {
        try {
            lock.lock();
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}