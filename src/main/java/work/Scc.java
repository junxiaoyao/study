package work;

import java.lang.reflect.Field;

/**
 * @description
 * @author: jxy
 * @create: 2019-08-08 15:30
 */
public class Scc {
    private String vcsad;

    public static void main(String[] args) {
        Class clazz=Scc.class;
        Field []fields=clazz.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field.getType());
            System.out.println(field.getType().getClass());
            System.out.println(field.getName());
        }
    }
    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
