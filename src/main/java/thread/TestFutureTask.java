package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-21 15:25
 */
public class TestFutureTask {

    public static void main(String[] args)throws Exception {
        FutureTask<Integer> futureTask=new FutureTask<Integer>(()->{
            Thread.sleep(3000);
            return (int)(Math.random()*100);
        });
        System.out.println("1111111111111111111111111");
        futureTask.run();
        System.out.println(futureTask.get());
        System.out.println("2222222222222222222222222");
    }

}
