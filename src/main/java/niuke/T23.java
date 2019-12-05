//package niuke;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description
// * @author: jxy
// * @create: 2019-09-30 14:54
// */
//// * 定义栈的数据结构，
//// * 请在该类型中实现一个能够得到栈中
//// * 所含最小元素的min函数（时间复杂度应为O（1））。
//// ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
//public class T23 {
//
//    List<Integer> list = new ArrayList<>();
//
//    public void push(int node) {
//        int temp;
//        for (int i=0;i<list.size();i++){
//            if (list.get(i)>node)
//        }
//    }
//
//    public void pop() {
//        list.remove(list.size() - 1);
//    }
//
//    public int top() {
//        return list.get(list.size() - 1);
//    }
//
//    public int min() {
//        return top();
//    }
//
//    public static void main(String[] args) {
//        T23 t23 = new T23();
//        for (int i = 0; i < 100; i++) {
//            t23.push((int) (Math.random() * 100));
//        }
//        System.out.println();
//    }
//}
