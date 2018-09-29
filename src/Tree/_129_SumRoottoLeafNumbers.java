package Tree;

/**
 * Created by sigong on 2018/9/17.
 */
public class _129_SumRoottoLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }

        return getRootToLeafSun(root, 0);
    }

    private int getRootToLeafSun(TreeNode root, int i) {
        int currentValue = i * 10 + root.val;
        if (root.right == null && root.left == null){
            return currentValue;
        }
        int left = 0, right = 0;
        if (root.left != null)
            left = getRootToLeafSun(root.left, currentValue);
        if (root.right != null)
            right = getRootToLeafSun(root.right, currentValue);
        return left + right;
    }

    public static void main(String[] args) {
        _129_SumRoottoLeafNumbers main = new _129_SumRoottoLeafNumbers();
        _129_SumRoottoLeafNumbers.TreeNode t1 = main.new TreeNode(4);
        _129_SumRoottoLeafNumbers.TreeNode t2 = main.new TreeNode(9);
        _129_SumRoottoLeafNumbers.TreeNode t3 = main.new TreeNode(0);
        _129_SumRoottoLeafNumbers.TreeNode t4 = main.new TreeNode(5);
        _129_SumRoottoLeafNumbers.TreeNode t5 = main.new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        System.out.println(main.sumNumbers(t1));;
    }
}
