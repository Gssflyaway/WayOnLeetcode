package Tree;

/**
 * Created by sigong on 2018/9/7.
 */
public class _112_PathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        return handle(root, sum, 0);

    }

    private boolean handle(TreeNode root, int sum, int fatherSum){
        if (root.left == null && root.right == null){
            if (sum == fatherSum + root.val){
                return true;
            }else {
                return false;
            }
        }

        fatherSum += root.val;

        boolean left = false;
        boolean right = false;

        if (root.left != null){
            left = handle(root.left, sum, fatherSum);
        }

        if (root.right != null){
            right = handle(root.right, sum, fatherSum);
        }

        return left | right;
    }

    public static void main(String[] args) {
        _112_PathSum main = new _112_PathSum();

        _112_PathSum.TreeNode t1 = main.new TreeNode(5);
        _112_PathSum.TreeNode t2 = main.new TreeNode(4);
        _112_PathSum.TreeNode t3 = main.new TreeNode(8);
        _112_PathSum.TreeNode t4 = main.new TreeNode(11);
        _112_PathSum.TreeNode t5 = main.new TreeNode(13);
        _112_PathSum.TreeNode t6 = main.new TreeNode(4);
        _112_PathSum.TreeNode t7 = main.new TreeNode(7);
        _112_PathSum.TreeNode t8 = main.new TreeNode(2);
        _112_PathSum.TreeNode t9 = main.new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.right = t9;

        System.out.println(main.hasPathSum(t1, 22));;
    }
}
