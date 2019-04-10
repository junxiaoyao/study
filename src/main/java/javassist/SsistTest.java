package javassist;

import java.lang.reflect.Method;

/**
 * @Auther: jxy
 * @Date: 2019/4/9 21:28
 * @Description:
 */
public class SsistTest {
    public static void main(String[] args) {

        try {
            addMethodTest();
//            Class c = User.class;
//            Object o = c.newInstance();
//            Method m = c.getDeclaredMethod("sum", int.class, int.class);
//            int result=(int)m.invoke(o,5,10);
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMethodTest() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("javassist.User");
        CtMethod ctMethod = new CtMethod(CtClass.intType, "sum", new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);
        ctMethod.setBody("{ return $1+$2;}");
        ctClass.addMethod(ctMethod);
        Object o=ctClass.toClass().newInstance();
        Method m=o.getClass().getDeclaredMethod("sum",int.class,int.class);
        System.out.println(m.invoke(o,5,10));
        ctClass.writeFile("F:/test");
    }
    public void sample() {
        try {
            ClassPool pool = ClassPool.getDefault();
            // 读取com.itmayiedu.User
            CtClass userClass = pool.get("javassist.User");
            CtMethod method = new CtMethod(CtClass.voidType, "sum", new CtClass[]{CtClass.intType, CtClass.intType},
                    userClass);
            method.setBody("{System.out.println(\"sun:\" + ($1 + $2));}");
            // 添加方法
            userClass.addMethod(method);
            //  userClass.writeFile("F:/test");
            // 动态执行方法
            Class clazz = userClass.toClass();
            Object newInstance = clazz.newInstance();

            Method sumMethod = clazz.getDeclaredMethod("sum", int.class, int.class);
            System.out.println("开启事物");
            sumMethod.invoke(newInstance, 2, 5);
            // 使用 javassist 实现动态代理。
            System.out.println("提交事物");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
