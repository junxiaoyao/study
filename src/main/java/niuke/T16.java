package niuke;

import java.util.ArrayList;
import java.util.List;

//输入两个单调递增的链表，
// 输出两个链表合成后的链表，
// 当然我们需要合成后的链表满足单调不减规则。
public class T16 {

  public ListNode Merge(ListNode list1, ListNode list2) {
    ListNode node = null;
    ListNode temp = null;
    List<Integer> list = new ArrayList<>();
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        list.add(list1.val);
        list1 = list1.next;
      } else {
        list.add(list2.val);
        list2 = list2.next;
      }
    }
    while (list1 != null) {
      list.add(list1.val);
      list1 = list1.next;
    }
    while (list2 != null) {
      list.add(list2.val);
      list2 = list2.next;
    }
    if (list.size() > 0) {
      node = new ListNode(list.get(0));
      temp = node;
    }
    for (int i = 1; i < list.size(); i++) {
      temp.next = new ListNode(list.get(i));
      temp = temp.next;
    }
    return node;
  }
}
