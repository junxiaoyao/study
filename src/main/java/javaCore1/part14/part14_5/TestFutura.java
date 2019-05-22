package javaCore1.part14.part14_5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TestFutura {

  public static void main(String[] args) throws Exception {
    Callable<Integer> callable = new CallableTest<>(5000);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Integer> future = executorService.submit(callable);

    FutureTask<Integer> futureTask = new FutureTask<>(callable);
    Integer integer = new Integer(2);
    ///方法执行完会返回输入的对象
    Future<Integer> future2 = executorService
        .submit(() -> System.out.println("i say i am cool"), integer);
    new Thread(futureTask).start();
    System.out.println("-------------------------------");
    //2000, TimeUnit.MILLISECONDS 可以传入等待时间，超时抛出超时异常
    Integer is = future2.get();
    System.out.println("integer:" + is);
    System.out.println(future.get());
    System.out.println(futureTask.get());
    System.out.println("-------------------------------");
    executorService.shutdown();
  }
}

class CallableTest<V> implements Callable<V> {

  private int count;

  public CallableTest(int count) {
    this.count = count;
  }

  @Override
  public V call() throws Exception {
    Thread.sleep(count);
    Integer integer = new Integer((int) (Math.random() * count));
    return (V) integer;
  }
}