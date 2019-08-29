package SomeTest.reference;

import java.lang.ref.SoftReference;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-29 10:19
 */
public class TestSoftRef {

    public static void main(String args[]) {
        SoftReference<String> str = new SoftReference<String>(new String("abc"));
        System.out.println(str.get());
        //通知JVM进行内存回收
        System.gc();
        System.out.println(str.get());
    }
}
