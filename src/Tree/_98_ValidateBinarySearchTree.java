package Tree;

/**
 * Created by sigong on 2018/9/19.
 */
public class _98_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //错！！！这并不是中序遍历！！！
//    public boolean isValidBST(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//
//        if (!isValidBST(root.left)){
//            return false;
//        }
//        if (root.left != null && root.val <= root.left.val){
//            return false;
//        }
//        if (root.right != null && root.val >= root.right.val){
//            return false;
//        }
//        if (!isValidBST(root.right)){
//            return false;
//        }
//        return true;
//    }

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;

        return traverseTree(root);
    }

    private boolean traverseTree(TreeNode root) {
        if (root == null){
            return true;
        }

        boolean left = traverseTree(root.left);
        if (pre != null){
            if (pre.val >= root.val){
                return false;
            }
        }
        pre = root;
        boolean right = traverseTree(root.right);
        return left & right;
    }

    public static void main(String[] args) {
        _98_ValidateBinarySearchTree main = new _98_ValidateBinarySearchTree();

//        _98_ValidateBinarySearchTree.TreeNode t1 = main.new TreeNode(10);
//        _98_ValidateBinarySearchTree.TreeNode t2 = main.new TreeNode(4);
//        _98_ValidateBinarySearchTree.TreeNode t3 = main.new TreeNode(15);
//        _98_ValidateBinarySearchTree.TreeNode t4 = main.new TreeNode(2);
//        _98_ValidateBinarySearchTree.TreeNode t5 = main.new TreeNode(5);
//        _98_ValidateBinarySearchTree.TreeNode t6 = main.new TreeNode(6);
//        _98_ValidateBinarySearchTree.TreeNode t7 = main.new TreeNode(17);

//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;

        _98_ValidateBinarySearchTree.TreeNode t1 = main.new TreeNode(1);
        _98_ValidateBinarySearchTree.TreeNode t2 = main.new TreeNode(1);

        t1.left = t2;

        System.out.println(main.isValidBST(t1));

    }
}
