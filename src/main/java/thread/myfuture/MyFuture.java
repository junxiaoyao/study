package thread.myfuture;
import java.util.concurrent.Callable;
/**
 * @description
 * @author: jxy
 * @create: 2020-01-10 10:23
 */
public class MyFuture<V> implements Runnable {
    private Callable<V> callable;
    private V result;
    private byte[] lock = new byte[1];
    public MyFuture(Callable<V> callable) {
        this.callable = callable;
    }

    public V get() {
        try {
            synchronized (lock) {
                lock.wait();
            }
            return result;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    public void run() {
        try {
           result= callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }
}
