package SomeTest.testSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description
 * @author: jxy
 * @create: 2019-12-06 15:30
 */
public class TestCollectionSort {

    public static void main(String[] args) {
        List<TestCompare> list = new ArrayList<>();
        TestCompare c1 = new TestCompare(50, "5454");
        TestCompare c2 = new TestCompare(10, "5454");
        TestCompare c3 = new TestCompare(66, "5454");
        list.add(c1);
        list.add(c2);
        list.add(c3);
        Collections.sort(list);
        list.remove(c1);
        System.out.println();
    }
}

@Data
@AllArgsConstructor
class TestCompare implements Comparable<TestCompare> {

    private int num;

    private String str;

    @Override public int compareTo(TestCompare o) {
        return this.num-o.getNum();
    }
}
