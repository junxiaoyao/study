package readmeStudy.data_structure.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-18 15:04
 */
public class QueueStudy_1 {

  public static void main(String[] args) {
    //test_deque();
    test_LinkedList();
  }

  //deque测试
  public static void test_deque() {
    Deque<String> deque = new ArrayDeque<>();
    deque.add("1");
    deque.add("2");
    deque.remove();
    deque.remove();
    System.out.println(deque.peek());
  }

  //测试linkedlist并发
  public static void test_LinkedList() {
 List<Integer> list = new LinkedList<>();
    Test_LinkedList_Runable runable=new Test_LinkedList_Runable(list);
    new Thread(runable).start();
    new Thread(runable).start();
    new Thread(runable).start();
    new Thread(runable).start();
    while (Thread.activeCount()>1)
      Thread.yield();
    System.out.println(list.size());
    System.out.println(list.get(list.size()-1));
  }

}

class Test_LinkedList_Runable implements Runnable {

  private List<Integer> list;

  public Test_LinkedList_Runable(List<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      list.add(i);
    }
  }
}