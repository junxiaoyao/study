package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @description
 * @author: jxy
 * @create: 2020-01-16 09:01
 */
// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class T27 {

    /**
     * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right = null; public TreeNode(int val) {
     * this.val = val; } }
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }
        while (deque.size() > 0) {
            TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        return list;
    }

}
