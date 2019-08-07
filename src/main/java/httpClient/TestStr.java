package httpClient;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-31 16:58
 */
public class TestStr {

    public static void main(String[] args) {
        String a="aaaa";
        String b="bbbb";
        a=a+b;
        b=a.substring(0,a.length()-b.length());
        System.out.println(b);
    }
}
