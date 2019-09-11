package jvm.testInit;

/**
 * @description
 * @author: jxy
 * @create: 2019-09-11 15:48
 */
class B {
    static int value = 100;
    static {
        System.out.println("Class B is initialized");// 输出
    }
}

class A extends B {
    static {
        System.out.println("Class A is initialized"); // 不输出
    }
}

public class LoadTest {
    public static void main(String[] args) {
        System.out.println(A.value);// 输出100
    }
}

