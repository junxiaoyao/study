package design.cloneModel;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 15:09
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        User u1 = new User();
        u1.setClassName(new ClassName());
        u1.setUserName("xiu");
        User u2 = u1.clone();
        System.out.println(u2.getUserName());
        System.out.println(u1==u2);
        System.out.println(u1.getClassName()==u2.getClassName());
    }
}
