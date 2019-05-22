package javaCore1.part9.part9_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import org.apache.activemq.util.LRUSet;

public class T1 {

  public static void main(String[] args) {
    Set set=new HashSet();
    set.add("bbb");
    set.add("aaa");
    set.add("ccc");
    Iterator<String> iterator=set.iterator();
    List<String> list=new ArrayList<>();
    list.add("sd");
    list.add("qe");
    ListIterator<String> listIterator=list.listIterator();
    listIterator.next();
    listIterator.add("qs");
    String ss="ss";
    System.out.println(ss.hashCode());
    System.out.println("ss".hashCode());
    System.out.println(new String("ss").hashCode());
    System.out.println(list.toString());
    Queue<String> queue=new PriorityQueue<>();
    queue.add("sss");
    queue.add("qqq");
    queue.add("aaa");
    System.out.println(queue.peek());
//    iterator.next();
//    iterator.remove();
//    iterator.remove();
    System.out.println(set.contains("aaa"));
    //测试集合是否支持随机访问，即通过下标访问
    System.out.println(set instanceof RandomAccess);
    //调用迭代器的for-each传入lambda表达式。会为每一个元素执行方法
    iterator.forEachRemaining(e-> System.out.println(e));
    System.out.println(set.size());
  }

  @Override
  public String toString() {
    return "T1{}";
  }
}
