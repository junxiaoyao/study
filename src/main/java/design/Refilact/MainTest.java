package design.Refilact;

import design.Refilact.UserT;

import java.lang.reflect.Constructor;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 14:07
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
        Class<?> aClass=Class.forName("main.java.design.Refilact.UserT");
        UserT userT=(UserT)aClass.newInstance();
        userT.setUserName("sdsdsd");
        Constructor constructor=aClass.getConstructor();
        userT =(UserT) constructor.newInstance();
        userT.setUserName("sssd");
    }
}
