package niuke;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-03 16:43
 *///操作给定的二叉树，将其变换为源二叉树的镜像。
public class T19 {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    TreeNode treeNode4 = new TreeNode(4);
    treeNode2.left = treeNode4;
    TreeNode treeNode5 = new TreeNode(5);
    treeNode3.right = treeNode5;
    new T19().Mirror(treeNode1);
    System.out.println();
  }

  public void Mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = mis(root);
    root = temp;
  }

  public TreeNode mis(TreeNode root) {
    TreeNode treeNode = null;
    if (root != null) {
      treeNode = new TreeNode(root.val);
      treeNode.left = mis(root.right);
      treeNode.right = mis(root.left);
    }
    return treeNode;
  }
}
