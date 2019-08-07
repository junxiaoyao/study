package patternTest;

/**
 * @description
 * @author: jxy
 * @create: 2019-07-29 15:23
 */
public class TestSplitString {

    public static void main(String[] args) {
        String string="a       b  a  a ";
        for(String a:string.split("\\s+")){
            System.out.println(a);
        }
    }
}
