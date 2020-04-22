package jvm;

/**
 * @description
 * @author: jxy
 * @create: 2020-03-27 16:12
 */
public class testFinal {

    //
    private final int sum1;

    private final int sum2;

    // 声明时初始化成员final变量
    private final int sum3 = 0;

    // 声明时初始化类final变量
    private static final int sum4 = 0;

    private static final int sum5;

    // 构造初始化成员final变量
    public testFinal() {
        sum2 = 0;
    }

    // 代码块初始化成员final变量
    {
        sum1 = 0;
    }
  // 代码块初始化成员类final变量
    static {
        sum5 = 0;
    }

    public static void main(String[] args) {

    }
}
