package niuke;

import java.util.Stack;

//用两个栈来实现一个队列，
// 完成队列的Push和Pop操作。
// 队列中的元素为int类型。
public class T5 {

  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public static void main(String[] args) {
    //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
    T5 t5 = new T5();
    t5.push(1);
    t5.push(2);
    t5.push(3);
    t5.pop();
    t5.pop();
    t5.push(4);
    t5.pop();
    t5.push(5);
    t5.pop();
    t5.pop();
    //System.out.println(t5.pop());
  }


  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    while (stack1.size() > 0) {
      stack2.push(stack1.pop());
    }
    int num = stack2.pop();
    while (stack2.size() > 0) {
      stack1.push(stack2.pop());
    }
    return num;
  }
}
