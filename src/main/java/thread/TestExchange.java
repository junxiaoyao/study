package thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-22 16:27
 */
public class TestExchange {

    public static void main(String[] args) throws Exception {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " i want change a message with you");
                String string = exchanger.exchange("hello ,i am jack!");
                System.out.println(Thread.currentThread().getName() + " get " + string);
            } catch (Exception e) {

            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " me too");
                Thread.sleep(2000);
                String string = exchanger.exchange("hello ,i am brd!");
                System.out.println(Thread.currentThread().getName() + " get " + string);
            } catch (Exception e) {

            }
        }).start();
    }
}
