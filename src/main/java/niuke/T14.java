package niuke;

import java.util.ArrayList;
import java.util.List;

//输入一个链表，输出该链表中倒数第k个结点。
//1,{1,2,3,4,5}
public class T14 {

  public ListNode FindKthToTail(ListNode head, int k) {
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    if (list.size() < k || k < 1) {
      return null;
    }
    return list.get(list.size() - k);
  }

  public void FindKthToTail(List<ListNode> list, ListNode head) {
    while (head != null) {
      list.add(head);
      head = head.next;
    }
  }

}
