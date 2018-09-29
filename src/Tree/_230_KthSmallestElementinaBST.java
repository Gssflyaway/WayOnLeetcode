package Tree;

/**
 * Created by sigong on 2018/9/29.
 */
public class _230_KthSmallestElementinaBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0){
            return 0;
        }

        return getKthSmallest(root, k);
    }

    private int getKthSmallest(TreeNode root, int k) {
        if (root.left != null){
            getKthSmallest(root.left, k);
        }
        index++;
        if (index == k){
            return root.val;
        }
        if (root.right != null){
            getKthSmallest(root.right, k);
        }
        return -1;
    }
}
