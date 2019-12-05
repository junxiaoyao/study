package javaCore1.part14.part14_5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestThreadLocal {

  public static void main(String[] args) {
    for (int i=0;i<10;i++)
    new Thread(new TestThreadLocalRunable()).start();
  }
}

class ThreadLocalValue {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class TestThreadLocalRunable implements Runnable {
  private ThreadLocal<ThreadLocalValue> threadLocal = new ThreadLocal(){
    @Override
    protected ThreadLocalValue initialValue() {
      return new ThreadLocalValue();
    }
  };
  @Override
  public void run() {
  //  ConcurrentHashMap
    ThreadLocalValue value = threadLocal.get();
    System.out.println(value.toString()+" code:"+value.hashCode());
  }
}