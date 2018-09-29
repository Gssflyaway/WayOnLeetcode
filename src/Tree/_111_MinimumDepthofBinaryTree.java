package Tree;

/**
 * Created by sigong on 2018/9/7.
 */
public class _111_MinimumDepthofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root.left == null && root.right == null){
            return 1;
        }

        int max = Integer.MAX_VALUE;

        int leftDepth = max;
        int rightDepth = max;

        if(root.left != null){
            leftDepth = getMinDepth(root.left);
        }

        if(root.right != null){
            rightDepth = getMinDepth(root.right);
        }

        if (leftDepth < rightDepth){
            return leftDepth + 1;
        }else {
            return rightDepth + 1;
        }
    }

    public static void main(String[] args) {
        _111_MinimumDepthofBinaryTree main = new _111_MinimumDepthofBinaryTree();
        _111_MinimumDepthofBinaryTree.TreeNode t1 = main.new TreeNode(3);
        _111_MinimumDepthofBinaryTree.TreeNode t2 = main.new TreeNode(9);
        _111_MinimumDepthofBinaryTree.TreeNode t3 = main.new TreeNode(20);
        _111_MinimumDepthofBinaryTree.TreeNode t4 = main.new TreeNode(15);
        _111_MinimumDepthofBinaryTree.TreeNode t5 = main.new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        int minDep = main.minDepth(t1);
        System.out.println(minDep);
    }
}
