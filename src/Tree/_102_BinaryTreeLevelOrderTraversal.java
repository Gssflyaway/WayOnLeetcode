package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sigong on 2018/9/20.
 */
public class _102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> levelTraversalList = new ArrayList<>();

        List<TreeNode> preLevel = new ArrayList<>();
        List<TreeNode> curLevel = new ArrayList<>();
        List<Integer> preLevelInt = new ArrayList<>();
        List<Integer> curLevelInt = new ArrayList<>();
        preLevel.add(root);
        preLevelInt.add(root.val);
//        levelTraversalList.add(preLevelInt);

        TreeNode treeNode;
        for (int i=0; i<preLevel.size(); i++){
            TreeNode tmp = preLevel.get(i);
            if (tmp.left != null){
                curLevel.add(tmp.left);
                curLevelInt.add(tmp.left.val);
            }
            if (tmp.right != null){
                curLevel.add(tmp.right);
                curLevelInt.add(tmp.right.val);
            }

            if (i == preLevel.size()-1){
                levelTraversalList.add(preLevelInt);
                if (curLevel.size() == 0){
                    return levelTraversalList;
                }
                preLevel = curLevel;
                preLevelInt = curLevelInt;
                curLevel = new ArrayList<>();
                curLevelInt = new ArrayList<>();
                i = -1;
            }
        }

        return levelTraversalList;
    }

    public static void main(String[] args) {
        _102_BinaryTreeLevelOrderTraversal main = new _102_BinaryTreeLevelOrderTraversal();

        _102_BinaryTreeLevelOrderTraversal.TreeNode t1 = main.new TreeNode(1);
        _102_BinaryTreeLevelOrderTraversal.TreeNode t2 = main.new TreeNode(2);
        _102_BinaryTreeLevelOrderTraversal.TreeNode t3 = main.new TreeNode(3);
        _102_BinaryTreeLevelOrderTraversal.TreeNode t4 = main.new TreeNode(4);
        _102_BinaryTreeLevelOrderTraversal.TreeNode t5 = main.new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        main.levelOrder_bak(t1);
    }

    public List<List<Integer>> levelOrder_bak(TreeNode root){
        if (root ==  null)
            return new LinkedList<>();
        Queue<TreeNode> nodeList = new LinkedList<>();

        nodeList.offer(root);
        nodeList.offer(null);

        List<List<Integer>> levelList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        while (!nodeList.isEmpty()){
            TreeNode treeNode = nodeList.poll();
            if (treeNode == null) {
                levelList.add(integerList);
                integerList = new ArrayList<>();
            } else {
                TreeNode nextNode = nodeList.peek();
                integerList.add(treeNode.val);
                if (treeNode.left != null)
                    nodeList.add(treeNode.left);
                if (treeNode.right != null)
                    nodeList.add(treeNode.right);
                if (nextNode == null)
                    nodeList.add(null);
            }
        }
        levelList.remove(levelList.size()-1);
        return levelList;
    }

}
