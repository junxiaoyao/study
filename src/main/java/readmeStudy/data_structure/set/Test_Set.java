package readmeStudy.data_structure.set;

import java.util.TreeSet;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-18 16:13
 */
public class Test_Set {

  public static void main(String[] args) {
    test_TreeSet();
  }

  public static void test_TreeSet() {
    /**
     * TreeSet 可以采用两种比较方式
     * 1.元素实现了Comparable接口，重写了compareTo方法
     * 2.实现一个Comparator接口的比较器，传入到容器(TreeSet)中
     * 3.两种同时存在时，以元素的compareTo为准
     */
    TreeSet ts = new TreeSet();
    ts.add("ccc");
    ts.add("aaa");
    ts.add("ddd");
    ts.add("bbb");
    ts.add("aaa");
    System.out.println(ts);
  }
}
