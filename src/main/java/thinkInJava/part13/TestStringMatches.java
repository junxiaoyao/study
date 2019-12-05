package thinkInJava.part13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-26 15:51
 */
public class TestStringMatches {

    public static void main(String[] args) {
        System.out.println("-123".matches("-?\\d+"));
        System.out.println("-23".matches("-?\\d+"));
        String string="hello world";
        String patternStr="h?\\w";
        Pattern pattern1=Pattern.compile(patternStr);
        Matcher matcher1=pattern1.matcher("hello world");
//        while (matcher1.find()){
//            System.out.println(matcher1.group());
//        }
        Pattern pattern=Pattern.compile("world");
        Matcher matcher=pattern.matcher("hello world");
        System.out.println(matcher.replaceAll("China"));
        while (matcher.find()){
         //   System.out.println(matcher.group());
        }
    }
}
