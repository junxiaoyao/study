package thread.share.t_volatile;

/**
 * @author : porteryao
 * @description : 描述
 * @date : 2020/11/20 10:51
 */
public class TestVolatile {

    public static void main(String[] args) {
        UseVolatile useVolatile = new UseVolatile(true);
        new Thread(new UseVolatileRunnable2(useVolatile)).start();
        new Thread(new UseVolatileRunnable1(useVolatile)).start();
    }
}


class UseVolatileRunnable1 implements Runnable {

    private UseVolatile lock;

    public UseVolatileRunnable1(UseVolatile lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("------------------允许线程2通过--------------");
            lock.setLock(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UseVolatileRunnable2 implements Runnable {

    private UseVolatile lock;

    public UseVolatileRunnable2(UseVolatile lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            if (!lock.isLock()) {
                System.out.println("------------------感谢线程1让我通过--------------");
                return;
            }
        }
    }
}

class UseVolatile {
    //volatile 保证可见性
    private volatile boolean lock;

    public UseVolatile(boolean lock) {
        this.lock = lock;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }
}
