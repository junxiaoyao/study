package connectionPool;

import java.sql.Connection;

/**
 * @Auther: jxy
 * @Date: 2019/3/20 21:38
 * @Description:
 */
public class MainTest {

    public static void main(String[] args) {
        DataConnectionManage.getConnection();
      /*  R1 threadConnection = new R1();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(threadConnection, "线程i:" + i);
            thread.start();
        }*/
    }
}

class R1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Connection connection = DataConnectionManage.getConnection();
            System.out.println(Thread.currentThread().getName() + ",connection:" + connection);
            DataConnectionManage.releaseConnection(connection);
        }
    }
}
