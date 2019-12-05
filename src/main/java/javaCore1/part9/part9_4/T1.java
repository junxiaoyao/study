package javaCore1.part9.part9_4;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class T1 {

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d"};
        List<String> list = Arrays.asList(strings);
        list.forEach(e -> System.out.println(e));
        list.set(0, "aa");
        list.forEach(e -> System.out.println(e));
        System.out.println(strings[0]);
        BitSet bitSet = new BitSet();
        bitSet.set(2);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(2));
    }
}
