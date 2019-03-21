package mybatis.proxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: jxy
 * @Date: 2019/3/21 21:08
 * @Description:
 */
public class SqlSessionManage {
    public static <T> T getDao(Class dao) {
        return (T) Proxy.newProxyInstance(dao.getClassLoader(), new Class[]{dao}, new MybatisProxy(dao));
    }
}
