package thread.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.sun.istack.NotNull;


/**
 * @description 一个简单的独占锁
 * @author: jxy
 * @create: 2020-04-22 15:37
 */
public class MyAcquireLock implements Lock, java.io.Serializable {
  private Sync sync=new Sync();
    private static class Sync extends AbstractQueuedSynchronizer {

        // 尝试获取锁
        @Override
        protected boolean tryAcquire(int acquires) {
            // 如果当前状态唯一，说明该锁已经被获取
            assert acquires == 1; // Otherwise unused
            // Cas修改状态为1，即成功获取锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 尝试释放锁
        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        //返回是否独占
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
        Condition newCondition(){
          return new ConditionObject();
        }
    }

    @Override
    public void lock() {
      sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
