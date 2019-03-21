package connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: jxy
 * @Date: 2019/3/20 20:27
 * @Description:
 */
public class ConnectionPool {
    //空闲连接
    private BlockingQueue<Connection> freeConnections = new LinkedBlockingDeque<>();
    //运行连接
    private BlockingQueue<Connection> activeConnections = new LinkedBlockingDeque<>();
    //计数器
    private AtomicInteger countConnections = new AtomicInteger();

    private ConnectonUtil connectonUtil;

    public ConnectionPool(ConnectonUtil connectonUtil) {
        System.out.println(" ConnectionPool ");
        this.connectonUtil = connectonUtil;
        this.initMain();
    }

    private void initMain() {
        System.out.println(" initMain ");
        freeInit();
    }

    private void freeInit() {
        for (int i = 0; i < connectonUtil.getInitialSize(); i++) {
            Connection connection = this.createConnection();
            freeConnections.offer(connection);
        }
    }

    //创建连接
    private Connection createConnection() {
        System.out.println(connectonUtil);
        System.out.println("创建连接");
        Connection connection = connectonUtil.createConnection();
        //失败则递归
        if (isAlife(connection)) {
            System.out.println("创建连接成功");
            return connection;
        } else {
            System.out.println("创建连接失败");
            return this.createConnection();
        }
    }

    //释放连接
    public synchronized void releaseConnection(Connection connection) {
        try {
            if (freeConnections.size() < connectonUtil.getMaxFree()) {
                if (isAlife(connection)) {
                    freeConnections.add(connection);
                }
            } else {
                connection.close();
            }
            activeConnections.remove(connection);
            countConnections.decrementAndGet();
            notifyAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public synchronized Connection getConnection() {
        try {
            Connection connection = null;
            if (countConnections.get() < connectonUtil.getMaxActive()) {
                if (freeConnections.size() > 0) {
                    connection = freeConnections.poll();
                } else {
                    connection = createConnection();
                }
                if (isAlife(connection)) {
                    activeConnections.offer(connection);
                    countConnections.incrementAndGet();
                } else {
                    connection = getConnection();
                }
            } else {
                wait(connectonUtil.getTimeBetweenEvictionRunsMillis());
                connection = getConnection();
            }
            return connection;
        } catch (Exception e) {
            return null;
        }

    }

    //判断连接是否可用
    private boolean isAlife(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return true;
    }
}
