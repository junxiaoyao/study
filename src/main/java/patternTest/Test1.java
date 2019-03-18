package patternTest;

import java.util.regex.Pattern;

/**
 * @Auther: jxy
 * @Date: 2019/3/12 16:35
 * @Description:
 */
public class Test1 {
    public static void main(String args[]){
        String content = "I am noob from runoob.com.";
        String content2="15525252";
        
        String pattern = ".*runoob.*";
        String pattern2 = "\\d";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        System.out.println("2? " + Pattern.matches(pattern2,content2));
    }
}
