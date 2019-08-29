package SomeTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-29 15:46
 */
public class TestPhantomReference {

    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue=new ReferenceQueue<>();
        PhantomReference<String> reference=new PhantomReference<>("abc",referenceQueue);
        System.out.println(reference.get());
    }
}
