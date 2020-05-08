package jvm_study.part4;

import org.omg.CORBA.ObjectHolder;

/**
 * @author jxy
 * @className TestJHsdb
 * @description 描述
 * @date 2020/4/23 21:56
 *
 */
public class TestJHsdb {
    static class Test{
        static ObjectHolder staticObject=new ObjectHolder();
        ObjectHolder instance=new ObjectHolder();
        void foo(){
            ObjectHolder localObj=new ObjectHolder();
            System.out.println("done");
        }
    }
    public static void main(String[] args) {
        Test test=new Test();
        test.foo();
    }
}
