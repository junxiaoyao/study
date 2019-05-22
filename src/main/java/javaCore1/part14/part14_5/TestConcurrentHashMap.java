package javaCore1.part14.part14_5;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TestConcurrentHashMap {

  public static void main(String[] args) {
    //注意：hashtable不允许将null设为键
    Map<String, String> hashMap =  new HashMap<>();
    hashMap.put(null,"sd");
    System.out.println(hashMap.get(null));
    Map<String, Integer> map = new ConcurrentHashMap<>();
    new Thread(new TestConcurrentHashMapRunable(map)).start();
    new Thread(new TestConcurrentHashMapRunable(map)).start();
    new Thread(new TestConcurrentHashMapRunable(map)).start();
    while (Thread.activeCount() > 1) {
      Thread.yield();
    }
    System.out.println(map.get("a"));
  }


}

class TestConcurrentHashMapRunable implements Runnable {

  private Map<String, Integer> map;

  public TestConcurrentHashMapRunable(Map<String, Integer> map) {
    this.map = map;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      map.compute("a", (k, v) -> v == null ? 1 : v + 1);
    }
  }
}
