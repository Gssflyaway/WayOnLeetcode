package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sigong on 2018/9/18.
 */
public class _199_BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new LinkedList<>();

        List<Integer> rightSideList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode rightSideNode = null;
        nodeQueue.add(root);
        nodeQueue.add(null);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            if (node == null){
                rightSideList.add(rightSideNode.val);
                if (nodeQueue.size() != 1){
                    nodeQueue.add(null);
                }
            }else{
                if (node.left != null){
                    nodeQueue.add(node.left);
                }
                if (node.right != null){
                    nodeQueue.add(node.right);
                }
            }
            rightSideNode = node;
        }
        return rightSideList;
    }

    public static void main(String[] args) {
        _199_BinaryTreeRightSideView main = new _199_BinaryTreeRightSideView();

        _199_BinaryTreeRightSideView.TreeNode t1 = main.new TreeNode(1);
        _199_BinaryTreeRightSideView.TreeNode t2 = main.new TreeNode(2);
        _199_BinaryTreeRightSideView.TreeNode t3 = main.new TreeNode(3);
        _199_BinaryTreeRightSideView.TreeNode t4 = main.new TreeNode(4);
        _199_BinaryTreeRightSideView.TreeNode t5 = main.new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;

        main.rightSideView(t1);
    }
}
