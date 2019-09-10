package jvm.monitor.reentrantLock;

public class MyReentrantLock {

    private boolean isLocked = false;

    private Thread lockedBy = null;

    private int lockedCount = 0;

    // 同一线程再次进入仍能获取锁，计数器加1
    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            // 如果计数器为0时表示当前线程执行完毕
            if (lockedCount == 0) {
                isLocked = false;
                lockedBy = null;
                notifyAll();
            }
        }
    }

}
