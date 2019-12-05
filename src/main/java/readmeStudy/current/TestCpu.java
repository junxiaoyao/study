package readmeStudy.current;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-21 16:41
 */
public class TestCpu {

  public static void main(String[] args) throws InterruptedException {
    test_Thread();
  }

  public static void test_Thread() throws InterruptedException {
    while (true) {
      for (int i = 0; i < Integer.MAX_VALUE; i++) {
        Runnable runnable = () -> {
          while (true) {
            try {
              Thread.sleep(10);
            } catch (InterruptedException e) {

            }
          }
        };
      }
    }
  }
}
