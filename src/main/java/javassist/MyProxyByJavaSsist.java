package javassist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

public class MyProxyByJavaSsist {
    @SuppressWarnings("deprecation")
    public static <T> T getProxy(Class clazz) throws IllegalAccessException, InstantiationException {
        //代理工程
        ProxyFactory factory = new ProxyFactory();
        //设置目标代理类为代理类的父类
        factory.setSuperclass(clazz);
        factory.setHandler(new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                System.out.println("--------------前--------");
                Object o = proceed.invoke(self, args);
                System.out.println("--------------后--------");
                return o;
            }
        });
        return (T) factory.createClass().newInstance();
    }

    public static void main(String[] args)throws Exception {
        User u=MyProxyByJavaSsist.getProxy(User.class);
        u.superS();
    }
}
