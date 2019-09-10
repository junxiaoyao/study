package javaCore1.part14.part14_9;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class ForkTest {

  public static void main(String[] args) {
    final int size=10000;
    double[] numbers=new double[size];
    for (int i=0;i<size;i++)
      numbers[i]=Math.random();
    Counter counter=new Counter(numbers,0,numbers.length,x->x>0.5);
    ForkJoinPool pool=new ForkJoinPool();
    pool.invoke(counter);
    System.out.println(counter.join());
  }

}

class Counter extends RecursiveTask<Integer> {

  public final static int THRESHOLD = 1000;
  private double[] values;
  private int form;
  private int to;
  private DoublePredicate filter;

  public Counter(double[] values, int form, int to, DoublePredicate filter) {
    this.values = values;
    this.form = form;
    this.to = to;
    this.filter = filter;
    System.out.println("name:"+Thread.currentThread().getName());
  }

  @Override
  protected Integer compute() {
    if (to - form < THRESHOLD) {
      int count = 0;
      for (int i = form; i < to; i++) {
        if (filter.test(values[i])) {
          count++;
        }
      }
      return count;
    } else {
      int mid = (form + to) / 2;
      Counter first = new Counter(values, form, mid, filter);
      Counter second = new Counter(values, mid, to, filter);
      invokeAll(first, second);
      return first.join() + second.join();
    }
  }
}
