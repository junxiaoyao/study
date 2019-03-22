package patternTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: jxy
 * @Date: 2019/3/22 10:54
 * @Description:
 */
public class ParTest {
    private static String REGEX = "#\\{name}";
    private static String INPUT = "insert into names(name,sex) values(#{name},#{sex})";
    private static String REPLACE = "?";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}
