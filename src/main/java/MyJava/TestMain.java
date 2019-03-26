package MyJava;
/**
 * @Auther: jxy
 * @Date: 2019/3/26 9:19
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        MyArrayList<Object> myArrayList = new MyArrayList<>(1);
        myArrayList.add("1");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add(4,"2");
        myArrayList.get(4);
        boolean s=myArrayList.remove("2");
        System.out.println(myArrayList.size());
    }
}
