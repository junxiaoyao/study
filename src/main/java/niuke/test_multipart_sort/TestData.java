package niuke.test_multipart_sort;

import java.util.TreeSet;

/**
 * @Auther: jxy
 * @Date: 2019/12/5 20:12
 * @Description:
 */
public class TestData {
    public static void main(String[] args) {
        TreeSet<ModelClass> treeSet=new TreeSet<>();
        ModelClass modelClass=new ModelClass(1,"sdasc","ssd");
        ModelClass modelClass2=new ModelClass(1,"sdasc","ssd");
        treeSet.add(modelClass);
        treeSet.add(modelClass2);
        System.out.println();
    }
}
