package SomeTest;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @description
 * @author: jxy
 * @create: 2019-11-25 14:47
 */
public class TestUnsafe {

    public static void main(String[] args) throws Exception {
        Field fl = Unsafe.class.getDeclaredField("theUnsafe");
        fl.setAccessible(true);
        Unsafe unsafe = (Unsafe) fl.get(null);
      //  function1(unsafe);
        function2(unsafe);
    }

    public static void function1(Unsafe unsafe) throws Exception {
        Class clazz = Target.class;
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fieldName:fieldOffset");
        for (Field f : fields) {
            System.out.println(f.getName() + ":" + unsafe.objectFieldOffset(f));
        }
        Target target = new Target();
        target.setIntParam(3);
        Field intFiled = clazz.getDeclaredField("intParam");
        intFiled.setAccessible(true);
        int a = (Integer) intFiled.get(target);
        System.out.println("原始值是:" + a);
        // intParam的字段偏移是12 原始值是3 我们要改为10
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
        int b = (Integer) intFiled.get(target);
        System.out.println("改变之后的值是:" + b);
        // 这个时候已经改为10了,所以会返回false
        System.out.println(unsafe.compareAndSwapInt(target, 12, 3, 10));
        System.out.println("---------------------------------------------------------");
    }

    public static void function2(Unsafe unsafe) throws Exception {
        Class clazz1 = User.class;
        Field[] fields1 = clazz1.getDeclaredFields();
        System.out.println("fieldName:fieldOffset");
        for (Field f : fields1) {
            /*
                name:12
                age:16
                address:20
             */
            System.out.println(f.getName() + ":" + unsafe.objectFieldOffset(f));
        }
        User user = new User("t", 2, "sa");
        Field age = clazz1.getDeclaredField("age");
        age.setAccessible(true);
        Field address=clazz1.getDeclaredField("address");
        address.setAccessible(true);
        String addressStr=address.get(user).toString();
        int var = (Integer) age.get(user);
        System.out.println("原始值是:" + var);
        // intParam的字段偏移是16 原始值是2 我们要改为10

        System.out.println(unsafe.compareAndSwapInt(user, unsafe.objectFieldOffset(age), 2, 10));
        System.out.println(unsafe.compareAndSwapObject(user,20L,"sa","test"));
        int b1 = (Integer) age.get(user);
        String addressStr2=address.get(user).toString();
        System.out.println("改变之后的str值是:" + addressStr2);
        System.out.println("改变之后的值是:" + b1);

    }
}

class Target {

     int intParam;

    long longParam;

    String strParam;

    String strParam2;

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }
}

class User {

    private String name;

    private int age;

    private String address;

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
