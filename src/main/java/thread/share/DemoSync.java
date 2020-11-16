package thread.share;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : porteryao
 * @description : 描述
 * @date : 2020/11/10 16:10
 */
public class DemoSync {
    public static void main(String[] args) {
        synchronized (DemoSync.class) {
        }
        method();
    }

    private static void method() {
    }
}
