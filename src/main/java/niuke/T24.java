package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description 定义栈的数据结构， 请在该类型中实现一个能够得到栈中所含最小元素的min函数 （时间复杂度应为O（1））。
 * @author: jxy
 * @create: 2019-12-12 16:16
 */
public class T24 {

    List<Integer> list = new ArrayList<>();

    public void push(int node) {
        list.add(node);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.remove(list.size() - 1);
    }

    public int min() {
       return Collections.min( list);
    }

    public static void main(String[] args) {
        T24 t24=new T24();
        t24.push(5);
        System.out.println(t24.min());
        // ["PSH3","MIN",
        // "PSH4","MIN","PSH2",
        // "MIN","PSH3","MIN",
        // "POP","MIN","POP",
        // "MIN","POP","MIN","PSH0","MIN"]

    }
}
