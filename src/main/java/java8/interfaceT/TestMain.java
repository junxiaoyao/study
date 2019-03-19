package java8.interfaceT;

/**
 * @Auther: jxy
 * @Date: 2019/3/18 15:16
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        InterfaceM interfaceM=new InterfaceM() {
            @Override
            public int getSize() {
                return 6;
            }
        };
        System.out.println(interfaceM.size());
    }
}
