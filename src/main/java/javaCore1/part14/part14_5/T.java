package javaCore1.part14.part14_5;

public class T {

  public static void main(String[] args) {
//    Lock lock=new ReentrantLock();
//    Condition condition=lock.newCondition();
//    condition.signalAll();
    TestInter inter=(e)->System.out.println(e);
    inter.show("sad");
    T2 o1 = new T2();
    o1.setName("o1");
    o1.setSize(20);
    RunAbleSetSize runAbleSetSize = new RunAbleSetSize(o1);
    RunAbleShow runAbleShow = new RunAbleShow(o1);
    new Thread(runAbleShow).start();
    new Thread(runAbleSetSize).start();
  }
}

class RunAbleSetSize implements Runnable {

  private T2 t2;

  public RunAbleSetSize(T2 t2) {
    this.t2 = t2;
  }

  @Override
  public void run() {
    while (true) {
      int size = (int) (Math.random() * 100);
      // System.out.println("设置值："+size);
      t2.setSize(size);
    }
  }
}

class RunAbleShow implements Runnable {

  private T2 t2;

  public RunAbleShow(T2 t2) {
    this.t2 = t2;
  }

  @Override
  public void run() {
    t2.show();
  }
}

class T2 {

  private int size;
  private String name;

  public int getSize() {
    return size;
  }

  public synchronized void setSize(int size) {
    this.size = size;
    notifyAll();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public synchronized void show() {
    try {
      while (size < 50) {
        // System.out.println("我将阻塞了：" + name);
        wait();
      }
      System.out.println("我输出：" + size);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      notifyAll();
    }
  }
}

interface TestInter {
  void show(String name);
}