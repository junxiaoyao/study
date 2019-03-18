package design.Refilact;

/**
 * @Auther: jxy
 * @Date: 2019/3/14 14:38
 * @Description:
 */
public class TestAnotationClass {
    public void say() {
        System.out.println("不含注解");
    }

    @MyAnnotion(name = "瞎搞")
    public void anSay() {
        System.out.println("含注解");
    }
}
