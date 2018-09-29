package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sigong on 2018/9/17.
 */
public class _144_BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> preList = new ArrayList<>();

        if (root == null){
            return preList;
        }

        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode treeNode = treeNodeStack.pop();
            preList.add(treeNode.val);
            if (treeNode.right != null){
                treeNodeStack.add(treeNode.right);
            }
            if (treeNode.left != null){
                treeNodeStack.add(treeNode.left);
            }
        }

        return preList;
    }

    public static void main(String[] args) {
        _144_BinaryTreePreorderTraversal main = new _144_BinaryTreePreorderTraversal();
        _144_BinaryTreePreorderTraversal.TreeNode t1 = main.new TreeNode(1);
        _144_BinaryTreePreorderTraversal.TreeNode t2 = main.new TreeNode(2);
        _144_BinaryTreePreorderTraversal.TreeNode t3 = main.new TreeNode(3);

        t1.right = t2;
        t2.left = t3;

        main.preorderTraversal(t1);

    }

}
