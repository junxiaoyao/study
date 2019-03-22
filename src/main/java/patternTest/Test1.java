package patternTest;

import java.lang.reflect.Parameter;
import java.util.regex.Pattern;

/**
 * @Auther: jxy
 * @Date: 2019/3/12 16:35
 * @Description:
 */
public class Test1 {
    public static void main(String args[]) {

        String content = "insert into names(name,sex) values(#{name},#{sex})";
        String content2 = "15525252";


      /*  int firstC = content.indexOf("#{");
        int lastC = content.indexOf("}");
        while (firstC > 0 && lastC > 0) {
            System.out.println(content.substring(firstC + 2, lastC));
            stringBuilder.append(content.substring(firstC+2, lastC)+",");
            content = content.substring(lastC + 1);
            firstC = content.indexOf("#{");
            lastC = content.indexOf("}");
        }*/
        //System.out.println(stringBuilder.toString());
        // String[] argss=stringBuilder.toString().split(",");

        //System.out.println(content.substring(firstC, lastC));
        String patter = ".*#\\{.*}.*";
        String pattern = ".*runoob.*";
        String pattern2 = "\\d*";
        boolean isMatchSql = Pattern.matches(patter, content);
        System.out.println("sql " + isMatchSql);
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        System.out.println("2? " + Pattern.matches(pattern2, content2));
    }
}
