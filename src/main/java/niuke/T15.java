package niuke;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//输入一个链表，反转链表后，输出新链表的表头。
public class T15 {

  public static void main(String[] args) {
    ListNode listNode1=new ListNode(5);
    ListNode listNode2=new ListNode(6);
    ListNode listNode3=new ListNode(7);
    listNode1.next=listNode2;
    listNode2.next=listNode3;
    ListNode node= ReverseList(listNode1);
    System.out.println();
  }
  public static ListNode ReverseList(ListNode head) {
    ListNode node = null;
    ListNode temp = null;
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    if (!stack.isEmpty()) {
      node = stack.pop();
    }
    temp = node;
    while (!stack.isEmpty()) {
      ListNode listNode= stack.pop();
      listNode.next=null;
      temp.next=listNode;
      temp=temp.next;
    }
    return node;
  }
}
