package SomeTest.testStr;

/**
 * @description
 * @author: jxy
 * @create: 2020-01-19 11:09
 */
public class T1 {

    public static void main(String[] args) {
        String s = new String(new char[] {'1', '1'});
        // 首先查找静态区是否存在该常量，
      // 如果存在返回地址，
      // 否则在静态区新建一个常量并返回
        s.intern();
        // String s1="11";
        System.out.println(s == "11");

        System.out.println(s == "11");
    }
}
