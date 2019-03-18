package myspring.ioc.annotion;

import com.google.protobuf.MapEntry;
import myspring.ioc.xmlUtil.ClassUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//注解版本
public class AnnotionPathContext {
    private String packName;
    ConcurrentHashMap<String, Object> beans = new ConcurrentHashMap<>();

    public AnnotionPathContext(String packName) throws Exception {
        this.packName = packName;
        initMain();
    }

    //初始化方法
    public void initMain() throws Exception {
        getObjects();
        autowiredFields();
    }

    //根据id获取对象
    public Object getBean(String id) throws Exception {
        if (beans.isEmpty()) {
            throw new Exception("该包下不含带注解的类");
        }
        Object o = beans.get(id);
        if (o == null) {
            throw new Exception("查找不到指定类");
        }
        return o;
    }

    //装配对象的属性主方法
    public void autowiredFields() throws Exception {
        for (Object o : beans.values()) {
            autowiredField(o);
        }
    }

    //装配对象的属性
    public void autowiredField(Object o) throws Exception {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getAnnotation(MyAutowired.class) != null) {
                String id = toLowerCaseFirstOne(field.getType().getSimpleName());
                field.set(o, getBean(id));
            }
        }
    }

    //实例化所有带注解的类
    public void getObjects() throws InstantiationException, IllegalAccessException {
        //得到所有含Myannotion注解的Class
        List<Class<?>> classes = ClassUtil.getClasses(packName);
        for (Class classNow : classes) {
            if (testHasAnnotion(classNow)) {
                beans.put(toLowerCaseFirstOne(classNow.getSimpleName()), newInstance(classNow));
            }
        }
    }

    public Object newInstance(Class c) throws InstantiationException, IllegalAccessException {
        return c.newInstance();
    }

    //判断class是否含自定义Service注解
    public boolean testHasAnnotion(Class classNow) {
        if (classNow.getAnnotation(MyService.class) != null) {
            return true;
        }
        return false;
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
