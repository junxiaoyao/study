package SomeTest.reference;

import java.lang.ref.WeakReference;

/**
 * @description 弱引用
 * @author: jxy
 * @create: 2019-08-29 15:39
 */
public class TestWeakRef {

    public static void main(String[] args) {
        WeakReference<String> reference = new WeakReference<String>(new String("str"));
        System.out.println(reference.get());
        System.gc();
        System.out.println(reference.get());
    }
}
