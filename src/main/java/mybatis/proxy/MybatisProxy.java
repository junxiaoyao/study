package mybatis.proxy;

import connectionPool.DataConnectionManage;
import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;
import mybatis.annotations.MySelect;
import mybatis.util.SqlUtil;
import myspring.ioc.util.AnnotationUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 21:05
 * @Description:
 */
public class MybatisProxy implements InvocationHandler {
    private Object object;

    public MybatisProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (AnnotationUtil.testMethodHasAnnotion(method, MyInsertInto.class)) {
            return insert(proxy, method, args);
        }
        if (AnnotationUtil.testMethodHasAnnotion(method, MySelect.class)) {
            return select(proxy, method, args);
        }
        return null;
    }

    private Object insert(Object proxy, Method method, Object[] args) throws Exception {
        MyInsertInto myInsertInto = AnnotationUtil.getMethodAnnotion(method, MyInsertInto.class);
        Map<String, Integer> mapSql = new HashMap<>();
        String sql = myInsertInto.value();
        sql = SqlUtil.getParameter(sql, mapSql);
        Connection connection = getConnection();
        SqlUtil.printOutSqlAndParams(sql, SqlUtil.paramzz(method, args, mapSql));
        Object o = SqlUtil.insertIntoUtil(connection, sql, SqlUtil.paramzz(method, args, mapSql));
        releaseConnection(connection);
        return o;
    }

    private Object select(Object proxy, Method method, Object[] args) throws Exception {
        MySelect mySelect = AnnotationUtil.getMethodAnnotion(method, MySelect.class);
        Map<String, Integer> mapSql = new HashMap<>();
        String sql = mySelect.value();
        sql = SqlUtil.getParameter(sql, mapSql);
        Connection connection = getConnection();
        Map<Object, Integer> paramzz = SqlUtil.paramzz(method, args, mapSql);
        SqlUtil.printOutSqlAndParams(sql, paramzz);
        ResultSet rs = SqlUtil.getObjectUtil(connection, sql, paramzz);
        releaseConnection(connection);
        return SqlUtil.loadData(rs, method);
    }

    //得到连接
    private Connection getConnection() {
        return DataConnectionManage.getConnection();
    }

    //释放连接
    private void releaseConnection(Connection connection) {
        DataConnectionManage.releaseConnection(connection);
    }
}
