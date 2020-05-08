package jvm_study.part8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author jxy
 * @className TestInvoke
 * @description 描述
 * @date 2020/5/8 21:38
 */
public class TestInvoke {
    public static void main(String[] args) {
        (new TestInvoke().new Son()).thinking();
    }


class GrandFather {
    void thinking() {
        System.out.println("i am a grandfather");
    }
}

class Father extends GrandFather {
    void thinking() {
        System.out.println("i am a Father");
    }
}

class Son extends Father {
    void thinking() {
        /*JDK7 update9只有由于限制问题（例如权限等）而只能访问到其分类方法*/
       /* try {
            MethodType mt = MethodType.methodType(void.class);
            MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
            mh.invoke(this);
        } catch (Throwable e) {

        }*/
       /*借助allowedModes,实现访问父类的父类方法*/
        try {
            MethodType mt = MethodType.methodType(void.class);
            Field lookupImp= MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImp.setAccessible(true);
            MethodHandle mh=((MethodHandles.Lookup)lookupImp.get(null)).findSpecial(GrandFather.class, "thinking", mt,GrandFather.class);
            mh.invoke(this);
        } catch (Throwable e) {

        }
    }
}
}