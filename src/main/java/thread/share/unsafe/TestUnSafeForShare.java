package thread.share.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author : porteryao
 * @description : 描述
 * @date : 2020/11/19 10:23
 */
public class TestUnSafeForShare {


    public static void main(String[] args) {
        Unsafe unsafe = getUnsafe();
        UnsafeTarget target = new UnsafeTarget("test", 15, 12);

        for (Field field : target.getClass().getDeclaredFields()) {
            System.out.println(
                    field.getName() + " type:" + field.getType().getSimpleName() + " distance: "
                            + unsafe.objectFieldOffset(field));
        }
        /**
         * name type:String distance: 16
         * age type:Integer distance: 20
         * sex type:int distance: 12
         */
        boolean sexSwapBool = unsafe.compareAndSwapInt(target, 12, 12, 13);
        boolean ageSwapBool1 = unsafe.compareAndSwapInt(target, 20, 15, 13);
        boolean ageSwapBool2 = unsafe.compareAndSwapObject(target, 20, 15, 13);
        System.out.println();
    }

    public static Unsafe getUnsafe() {
        Unsafe unsafe = null;
        try {
            Field fl = Unsafe.class.getDeclaredField("theUnsafe");
            fl.setAccessible(true);
            unsafe = (Unsafe) fl.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return unsafe;
        }

    }

}

class UnsafeTarget {

    private String name;
    private Integer age;
    private int sex;

    public UnsafeTarget(String name, Integer age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}