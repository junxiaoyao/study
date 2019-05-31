package niuke;

/**
 * @description
 * @author: jxy
 * @create: 2019-05-31 16:37
 */
//{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述 输入两棵二叉树A，B， 判断B是不是A的子结构。 （ps：我们约定空树不是任意一个树的子结构）
 */
public class T17 {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(8);
    TreeNode root2 = new TreeNode(8);
    TreeNode root3 = new TreeNode(7);
    TreeNode root4 = new TreeNode(9);
    TreeNode root5 = new TreeNode(2);
    TreeNode root6 = new TreeNode(8);
    TreeNode root7 = new TreeNode(9);
    TreeNode root8 = new TreeNode(2);
    root1.left = root2;
    root1.right = root3;
    root2.left = root4;
    root2.right = root5;
    root6.left = root7;
    root6.right = root8;
    T17 t17=new T17();
    System.out.println( t17.HasSubtree(root1,root6));
  }

  public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    if (root2 == null || root1 == null) {
      return false;
    }
    List<TreeNode> r1 = new ArrayList<>();
    getTreeNodeList(root1, r1);
    List<TreeNode> r2 = new ArrayList<>();
    getTreeNodeList(root2, r2);
    System.out.println(r1.toString());
    System.out.println(r2.toString());
    if (r1.containsAll(r2)) {
      return true;
    }
    return false;
  }

  public void getTreeNodeList(TreeNode root, List<TreeNode> list) {
    if (root != null) {
      list.add(root);
      getTreeNodeList(root.left, list);
      getTreeNodeList(root.right, list);
    }
  }
}
