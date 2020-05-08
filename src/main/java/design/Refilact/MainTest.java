package design.Refilact;

import java.lang.reflect.Method;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 14:07
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
        Class tclass=TestAnotationClass.class;
        Method[] methods=tclass.getDeclaredMethods();
        for (Method m:methods){
            if(m.getAnnotation(MyAnnotation.class)!=null){
                System.out.println(m.getAnnotation(MyAnnotation.class).name());
            }
            System.out.println(m.getAnnotation(MyAnnotation.class)!=null);
            m.invoke(tclass.newInstance());
        }
//     /*   Class<?> aClass=Class.forName("main.java.design.Refilact.UserT");
//        UserT userT=(UserT)aClass.newInstance();
//        userT.setUserName("sdsdsd");
//        Constructor constructor=aClass.getConstructor();
//        userT =(UserT) constructor.newInstance();
//        userT.setUserName("sssd");*/
    }
}
