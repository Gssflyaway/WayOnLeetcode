package Tree;

/**
 * Created by sigong on 2018/9/18.
 */
public class _222_CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftHeight = 0, rightHeight = 0;
        TreeNode tmp = root;
        while (tmp != null){
            leftHeight++;
            tmp = tmp.left;
        }
        tmp = root;
        while (tmp != null){
            rightHeight++;
            tmp = tmp.right;
        }
        if (rightHeight == leftHeight){
            return (int)Math.pow(2, rightHeight) - 1;
        }else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        _222_CountCompleteTreeNodes main = new _222_CountCompleteTreeNodes();

        _222_CountCompleteTreeNodes.TreeNode t1 = main.new TreeNode(1);
        _222_CountCompleteTreeNodes.TreeNode t2 = main.new TreeNode(2);
        _222_CountCompleteTreeNodes.TreeNode t3 = main.new TreeNode(3);
        _222_CountCompleteTreeNodes.TreeNode t4 = main.new TreeNode(4);
        _222_CountCompleteTreeNodes.TreeNode t5 = main.new TreeNode(5);
        _222_CountCompleteTreeNodes.TreeNode t6 = main.new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;

        System.out.println(main.countNodes(t1));
    }
}
