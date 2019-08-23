package thinkInJava.part7;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-22 10:01
 */
public class Bs extends Sub {

    private void say() {
        System.out.println("i am Bs say");
    }
    @Override
    public void say2() {
        System.out.println("i am Bs say2");
    }
    public static void main(String[] args) {
        Bs s=new Bs();
        s.say();
        Sub sub=(Sub)s;
        sub.say2();
        //不能调用private method
       // sub.say
    }
}
