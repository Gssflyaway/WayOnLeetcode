package Tree;

public class _110_BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return height(root)!=-1;

    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=height(node.right);
        if(rH==-1){
            return -1;
        }
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }


    public static void main(String[] args) {
        _110_BalancedBinaryTree main = new _110_BalancedBinaryTree();
        _110_BalancedBinaryTree.TreeNode t1 = main.new TreeNode(1);
        _110_BalancedBinaryTree.TreeNode t2 = main.new TreeNode(2);
        _110_BalancedBinaryTree.TreeNode t3 = main.new TreeNode(3);
        _110_BalancedBinaryTree.TreeNode t4 = main.new TreeNode(4);
        _110_BalancedBinaryTree.TreeNode t5 = main.new TreeNode(5);
        _110_BalancedBinaryTree.TreeNode t6 = main.new TreeNode(6);
        _110_BalancedBinaryTree.TreeNode t7 = main.new TreeNode(7);
        _110_BalancedBinaryTree.TreeNode t8 = main.new TreeNode(8);
        _110_BalancedBinaryTree.TreeNode t9 = main.new TreeNode(9);
        _110_BalancedBinaryTree.TreeNode t10 = main.new TreeNode(10);
        _110_BalancedBinaryTree.TreeNode t11 = main.new TreeNode(11);
        _110_BalancedBinaryTree.TreeNode t12 = main.new TreeNode(12);
        _110_BalancedBinaryTree.TreeNode t13 = main.new TreeNode(13);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t13;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t13.left = t9;
        t13.right = t10;

        t5.left = t11;
        t7.left = t12;

        System.out.println(main.isBalanced(t1));
    }
}
