package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import thread.myfuture.MyFuture;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-21 15:25
 */
public class TestFutureTask {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            Thread.currentThread().sleep(3000);
            return (int) (Math.random() * 100);
        });
        MyFuture<Integer> myFuture = new MyFuture<Integer>(() -> {
            Thread.currentThread().sleep(3000);
            return (int) (Math.random() * 100);
        });
        System.out.println("1111111111111111111111111");
        new Thread(myFuture).start();
        System.out.println("33333333333333333333333");
        System.out.println(myFuture.get());
        // System.out.println("1111111111111111111111111");
        // new Thread(futureTask).start();
        // //futureTask.run();
        // System.out.println("33333333333333333333333");
        // System.out.println(futureTask.get());
        // System.out.println("2222222222222222222222222");
    }

}
