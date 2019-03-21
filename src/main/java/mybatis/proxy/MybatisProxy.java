package mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
        System.out.println("进入了代理方法！");
        return null;
    }
}
