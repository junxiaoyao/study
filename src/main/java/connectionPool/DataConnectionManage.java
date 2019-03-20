package connectionPool;

import java.sql.Connection;

/**
 * @Auther: jxy
 * @Date: 2019/3/20 21:36
 * @Description:
 */
public class DataConnectionManage {
   static ConnectonUtil util= new ConnectonUtil();
    private  static ConnectionPool pool = new ConnectionPool(util);

    public static void releaseConnection(Connection connection) {
        pool.releaseConnection(connection);
    }

    public static Connection getConnection() {
        return pool.getConnection();
    }
}
