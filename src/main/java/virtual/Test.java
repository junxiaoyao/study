package virtual;

/**
 * @Auther: jxy
 * @Date: 2019/3/12 9:43
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //必须引起内存变化才会触发回收
        test = null;
        System.gc(); // 手动回收垃圾
    }

    @Override
    protected void finalize() throws Throwable {
        // gc回收垃圾之前调用
        System.out.println("垃圾回收机制...");
    }

}
