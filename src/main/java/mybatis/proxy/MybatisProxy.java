package mybatis.proxy;

import mybatis.annotations.MyInsertInto;
import mybatis.annotations.MyParam;
import mybatis.util.SqlUtil;
import myspring.ioc.util.AnnotationUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
        System.out.println("进入了代理方法！");
        if (AnnotationUtil.testMethodHasAnnotion(method, MyInsertInto.class)) {
            insert(proxy, method, args);
        }

        return 1;
    }

    private Object insert(Object proxy, Method method, Object[] args) {
        MyInsertInto myInsertInto = AnnotationUtil.getMethodAnnotion(method, MyInsertInto.class);
        Map<String, Integer> mapSql = new HashMap<>();
        String sql = myInsertInto.value();
        sql = SqlUtil.getParameter(sql, mapSql);
        Parameter[] parameters = method.getParameters();
        System.out.println(parameters[0].getAnnotation(MyParam.class).value());
        System.out.println(args[0].toString());
        Map<Object, Integer> parms=paramzz(method,args,mapSql);
        return 1;
    }

    public Map<Object, Integer> paramzz(Method method, Object[] args, Map<String, Integer> map) {
        Map<Object, Integer> parms = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < map.size(); i++) {
            String key = parameters[i].getAnnotation(MyParam.class).value();
            int value = map.get(key);
            parms.put(args[i], value);
        }
        return parms;
    }
}
