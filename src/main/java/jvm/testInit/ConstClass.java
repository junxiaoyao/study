package jvm.testInit;

import java.util.Calendar;

public class ConstClass {
  public final  static String value3 =returnString();
    // 若只使用其静态编译可以确定的变量不会引起类初始化
    // static代码块仅在类初始化时执行一次
    static {
        System.out.println("i am a constClass，static");
    }

    // 被 final static 限定，这样的常量叫做编译时常量
    // 对于这种常量，不需要初始化就可以读取。
    // 非final则会引起类初始化
    public final static String value = "final static";

    public static String value2 = "static";

    public static void say() {
        System.out.println("i am a static method");
    }

    public static String returnString() {
        return "i am a static method " + Calendar.getInstance().getTime();
    }
}
