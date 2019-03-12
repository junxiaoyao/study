package design.cloneModel;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 14:55
 * @Description:
 */
public class User implements Cloneable {
    private String userName;
    private ClassName className;

    @Override
    protected User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.className=this.className.clone();
        return user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }
}
