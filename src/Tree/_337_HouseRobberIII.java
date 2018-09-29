package Tree;

/**
 * Created by sigong on 2018/9/19.
 */
public class _337_HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Money{
        public int withCur = 0;
        public int withoutCur = 0;
    }

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }

        Money money = getMax(root);
        return Math.max(money.withoutCur, money.withCur);
    }

    public Money getMax(TreeNode root){
        if (root == null){
            return new Money();
        }
        Money money = new Money();;
        Money left = getMax(root.left);
        Money right = getMax(root.right);
        money.withCur = root.val + left.withoutCur + right.withoutCur;
        money.withoutCur = Math.max(left.withoutCur, left.withCur) + Math.max(right.withoutCur, right.withCur);
        return money;
    }
}
