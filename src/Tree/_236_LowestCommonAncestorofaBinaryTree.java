package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigong on 2018/9/21.
 */
public class _236_LowestCommonAncestorofaBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //占用空间过大
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null){
//            return null;
//        }
//        if (p == root || q == root){
//            return root;
//        }
//        if (p == q){
//            return p;
//        }
//
//        List<TreeNode> treeNodeList = new ArrayList<>();
//        int count = 0;
//        int index = 1;
//        int pIndex = -1;
//        int qIndex = -1;
//        treeNodeList.add(null);
//        treeNodeList.add(root);
//        while (true){
//            TreeNode treeNode = treeNodeList.get(index);
//            if (treeNode == null){
//                treeNodeList.add(null);
//                treeNodeList.add(null);
//            }else {
//                treeNodeList.add(treeNode.left);
//                treeNodeList.add(treeNode.right);
//            }
//
//            if (treeNode == p){
//                count++;
//                pIndex = index;
//            }
//            if (treeNode == q){
//                count++;
//                qIndex = index;
//            }
//            if (count == 2){
//                break;
//            }
//            index++;
//        }
//
//        index = getClosestAncestor(pIndex, qIndex);
//        return treeNodeList.get(index);
//    }
//
//    private int getClosestAncestor(int pIndex, int qIndex) {
//        int max = pIndex;
//        int min = qIndex;
//        if (pIndex < qIndex) {
//            max = qIndex;
//            min = pIndex;
//        }
//
//        while (true){
//            max /= 2;
//            if (max == min){
//                return min;
//            }
//            if (max < min){
//                int tmp = max;
//                max = min;
//                min = tmp;
//            }
//        }
//    }

    //这个题思路就是首先要先确定给的两个node是否都在tree里，
    // 如果都在tree里的话，就可以分成3种情况，第一种情况是两个节点是在公共祖先的左右两侧，第二种情况是都在树的左侧，第三种情况是都在树的右侧，
    // 如果是第二，第三种情况的话，公共祖先就在给定的两个点中比较上面的那一个。
    // 如果是第一种那么左子树有就返回有，右子树有就返回有，如果左右都有就代表这个节点是最近的父节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p){
            return p;
        }
        if (root == q){
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        _236_LowestCommonAncestorofaBinaryTree main = new _236_LowestCommonAncestorofaBinaryTree();

        _236_LowestCommonAncestorofaBinaryTree.TreeNode t1 = main.new TreeNode(3);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t2 = main.new TreeNode(5);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t3 = main.new TreeNode(1);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t4 = main.new TreeNode(6);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t5 = main.new TreeNode(2);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t6 = main.new TreeNode(0);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t7 = main.new TreeNode(8);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t8 = main.new TreeNode(7);
        _236_LowestCommonAncestorofaBinaryTree.TreeNode t9 = main.new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;

        System.out.println(main.lowestCommonAncestor(t1, t2, t3).val);
    }
}
