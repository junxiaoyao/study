package MyJava;
/**
 * @Auther: jxy
 * @Date: 2019/3/26 9:19
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        MyArrayList<MyArrayList> myArrayList = new MyArrayList<>(1);
        myArrayList.add(new MyArrayList<>(1));
        myArrayList.add(new MyArrayList<>(2));
        myArrayList.add(new MyArrayList<>(3));
        myArrayList.add(new MyArrayList<>(4));
        myArrayList.add(4,new MyArrayList<>(5));
        MyArrayList m=  myArrayList.get(4);
        boolean s=myArrayList.remove(m);
        System.out.println(myArrayList.size());
    }
}
