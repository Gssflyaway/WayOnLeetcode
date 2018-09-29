package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sigong on 2018/9/17.
 */
public class _145_BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> postList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode treeNode = treeNodeStack.pop();
            postList.add(0, treeNode.val);
            if (treeNode.left != null){
                treeNodeStack.add(treeNode.left);
            }
            if (treeNode.right != null){
                treeNodeStack.add(treeNode.right);
            }
        }

        return postList;
    }
}
