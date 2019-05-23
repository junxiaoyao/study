package niuke;
//题目描述
//输入一个链表，
//按链表值从尾到头的顺序返回一个ArrayList。

import java.util.ArrayList;

public class T3 {

  public static void main(String[] args) {
    ListNode listNode1=new ListNode(5);
    ListNode listNode2=new ListNode(6);
    ListNode listNode3=new ListNode(7);
    listNode1.next=listNode2;
    listNode2.next=listNode3;
    ArrayList<Integer> list= printListFromTailToHead(listNode1);
    System.out.println(list.toString());
  }

  public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> list=new ArrayList<>();
    while (listNode!=null){
      list.add(0,listNode.val);
      listNode=listNode.next;
    }
    return list;
  }
}

class ListNode {
  int val;
  ListNode next = null;
  ListNode(int val) {
    this.val = val;
  }
}
