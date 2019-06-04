package niuke;

import java.util.Iterator;
import java.util.Stack;
/**
 * @description
 * @author: jxy
 * @create: 2019-06-04 10:26
 */

/**
 * 定义栈的数据结构， 请在该类型中实现一个能够得到栈中所含最小元素的min函数 （时间复杂度应为O（1））。
 */
public class T21 {

  private Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    T21 t21 = new T21();
  }

  public void push(int node) {
    stack.push(node);
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int min() {
    int min = stack.peek();
    Iterator<Integer> iterator = stack.iterator();
    while (iterator.hasNext()) {
      int t = iterator.next();
      if (t < min) {
        min = t;
      }
    }
    return min;
  }
}
