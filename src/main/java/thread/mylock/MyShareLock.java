package thread.mylock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author : porteryao
 * @description : 描述
 * @date : 2020/11/13 14:05
 */
public class MyShareLock {
    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }
    }
}
