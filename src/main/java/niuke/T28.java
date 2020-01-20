package niuke;

/**
 * @description
 * @author: jxy
 * @create: 2020-01-17 16:38
 */
// 输入一个复杂链表
// （每个节点中有节点值，
// 以及两个指针，
// 一个指向下一个节点，
// 另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class T28 {

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;
        RandomListNode root = new RandomListNode(pHead.label);
        if (pHead.next != null) {
            root.next = Clone(pHead.next);
        }
        if (pHead.random != null) {
            root.random = Clone(pHead.random);
        }
        return root;
    }

    public void digui(RandomListNode pHead) {

        if (pHead == null) {
            return;
        }
        RandomListNode temp = new RandomListNode(pHead.label);
        if (pHead.next != null) {
            temp.next = new RandomListNode(pHead.next.label);
            digui(pHead.next);
        }
        if (pHead.random != null) {
            temp.random = new RandomListNode(pHead.random.label);
            digui(pHead.random);
        }
        pHead = temp;
    }
}
