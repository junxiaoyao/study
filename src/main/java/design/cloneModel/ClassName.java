package design.cloneModel;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 14:56
 * @Description:
 */
public class ClassName implements Cloneable{
    private String className="xiu";

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    protected ClassName clone() throws CloneNotSupportedException {
        return (ClassName) super.clone();
    }
}
