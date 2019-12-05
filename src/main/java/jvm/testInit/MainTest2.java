package jvm.testInit;

public class MainTest2 {

    public static void main(String[] args) throws Exception {
        // 若只使用其静态编译可以确定的变量不会引起类初始化

        // ConstClass.class.newInstance();
        // 调用其类静态方法，会使类初始化
        // ConstClass.say();
        // 用类字面常量 .class和Class.forName都可以创建对类的应用，
        // 但是不同点在于，ConstClass.class创建Class对象的应用时，
        // 不会自动初始化该Class对象（static子句不会执行）
        // Class clazz = ConstClass.class;
        // Class c = Class.forName("jvm.testInit.ConstClass");
        // System.out.println(clazz == c);
        // 若只使用其静态编译可以确定的变量不会引起类初始化
        System.out.println(ConstClass.value);
        System.out.println(ConstClass.value3);
        Class c2 = Class.forName("jvm.testInit.ConstClass");
        // printLnH("bs");
    }

    public static void printLnH(String str) {
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            default:
                System.out.println("bye");
        }
    }
}
