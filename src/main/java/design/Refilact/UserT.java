package design.Refilact;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 14:06
 * @Description:
 */
public class UserT {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        System.out.println("调用setter 方法，set:"+userName);
    }
}
