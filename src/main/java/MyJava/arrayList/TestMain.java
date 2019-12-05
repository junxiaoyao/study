package MyJava.arrayList;
/**
 * @Auther: jxy
 * @Date: 2019/3/26 9:19
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
//        MyArrayList<MyArrayList> myArrayList = new MyArrayList<>(1);
//        myArrayList.add(new MyArrayList<>(1));
//        myArrayList.add(new MyArrayList<>(2));
//        myArrayList.add(new MyArrayList<>(3));
//        myArrayList.add(new MyArrayList<>(4));
//        myArrayList.add(4,new MyArrayList<>(5));
//        MyArrayList m=  myArrayList.get(4);
//        boolean s=myArrayList.remove(m);
//        System.out.println(myArrayList.size());
        MyArrayList<String> stringMyArrayList = new MyArrayList<>(1);
        stringMyArrayList.add("scc");
        stringMyArrayList.add(0,"000");
        stringMyArrayList.add(2,"222");
        stringMyArrayList.remove("000");
        System.out.println();
    }
}
