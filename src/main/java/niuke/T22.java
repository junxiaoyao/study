package niuke;

import java.util.Stack;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-04 16:44
 */
//输入两个整数序列，
// 第一个序列表示栈的压入顺序，
// 请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，
// 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）
public class T22 {

  public static void main(String[] args) {
    int[] num1={1,2,3,4,5};
    int[] num2={4,5,3,2,1};
    System.out.println(new T22().IsPopOrder(num1,num2));
  }
  public boolean IsPopOrder(int[] pushA, int[] popA) {
    if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
    Stack<Integer> st = new Stack<Integer>();
    int i = 0;
    int j = 0;
    st.push(pushA[i++]);
    while(j <= popA.length-1){
      while(popA[j] != st.peek()){
        if(i == pushA.length) return false;
        st.push(pushA[i++]);
      }
      j++;
      st.pop();
    }
    return true;
//    Stack<Integer> stack = new Stack<>();
//    int i = 0;
//    int j = 0;
//    stack.push(pushA[i++]);
//    while (i<=pushA.length-1){
//      while (pushA[i]!=popA[j]){
//        if(i == pushA.length) return false;
//        stack.push(pushA[i++]);
//      }
//      j++;
//      stack.pop();
//    }
//    return false;
  }
}
