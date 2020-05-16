package jvm_study.part10;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jxy
 * @className TestType
 * @description 描述
 * @date 2020/5/11 20:57
 */
public class TestType {
    public static void main(String[] args) {
        List<String> list=new LinkedList<>();
        List<Integer> list2=new LinkedList<>();
        System.out.println(list.getClass()== list2.getClass());
    }

}
