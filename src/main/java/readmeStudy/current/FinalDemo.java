package readmeStudy.current;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-21 14:39
 */
public class FinalDemo {

  private int a;  //普通域
  private final int b; //final域
  private static FinalDemo finalDemo;

  public FinalDemo() {
    a = 1; // 1. 写普通域
    b = 2; // 2. 写final域
  }

  public static void writer() {
    finalDemo = new FinalDemo();
  }

  public static void reader() {
    FinalDemo demo = finalDemo; // 3.读对象引用
    while (demo==null)
      Thread.yield();
    int a = demo.a;    //4.读普通域
    int b = demo.b;    //5.读final域
  }

  public static void main(String[] args) {
    new Thread(new RuA(false)).start();
    new Thread(new RuA(true)).start();
  }
}

class RuA implements Runnable {

  private boolean read;

  public RuA(boolean read) {
    this.read = read;
  }

  @Override
  public void run() {
    if (read) {
      FinalDemo.reader();
    } else {
      FinalDemo.writer();
    }
  }
}