package thinkInJava.part2;



/**
 * @description
 * @author: jxy
 * @create: 2019-08-21 09:30
 */
public class TestStatic {
static int i=47;

    public static void main(String[] args) {
        TestStatic testStatic=new TestStatic();
        System.out.println(TestStatic.i);
        System.out.println(testStatic.i);
    }
}
