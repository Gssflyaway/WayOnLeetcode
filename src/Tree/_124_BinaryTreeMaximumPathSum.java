package Tree;

/**
 * Created by sigong on 2018/9/10.
 */
public class _124_BinaryTreeMaximumPathSum {
    //遍历到当前节点的全局最大值
    private int max = Integer.MIN_VALUE;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return max;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        //不管root是什么值，只要左边节点或者右边节点小于0，那么包含当前root节点的最大值就不应该加上左边或者右边节点
        //而且这里的值要么取左边要么取右边，因为这个返回值是要和上一层一起计算的，如果左右都取了那么这条路径就有分叉了
        int left = Math.max(0, getMaxSum(root.left));
        int right = Math.max(0, getMaxSum(root.right));

        //含有root节点值的最大值，这是为了给上一层的节点去算
        int maxValueWithRoot = Math.max(left + root.val, right + root.val);

        //这样会错！！比如只有一个接点，且值为-1，这样算出来的就是0
        //不需要这样算，是因为left和right其实在但当前节点的下一层就已经算过了
//        int maxValue = Math.max(Math.max(left, right), right + left + root.val);
//        if (maxValue > max){
//            max = maxValue;
//        }

        //如果left,right为正，那么就全加起来，否则都+0，与原先的max比较
        max = Math.max(max, right+left+root.val);

        return maxValueWithRoot;
    }


    public static void main(String[] args) {
        _124_BinaryTreeMaximumPathSum main = new _124_BinaryTreeMaximumPathSum();
        _124_BinaryTreeMaximumPathSum.TreeNode t1 = main.new TreeNode(1);
        _124_BinaryTreeMaximumPathSum.TreeNode t2 = main.new TreeNode(2);
        _124_BinaryTreeMaximumPathSum.TreeNode t3 = main.new TreeNode(3);
//        _124_BinaryTreeMaximumPathSum.TreeNode t4 = main.new TreeNode(15);
//        _124_BinaryTreeMaximumPathSum.TreeNode t5 = main.new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;

        System.out.println(main.maxPathSum(t1));
    }
}
