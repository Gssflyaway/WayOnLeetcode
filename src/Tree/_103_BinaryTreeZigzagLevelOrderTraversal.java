package Tree;

import java.util.*;

/**
 * Created by sigong on 2018/9/3.
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> oddTreeNodesStack = new Stack<>();
        Stack<TreeNode> evenTreeNodesStack = new Stack<>();
        List<List<Integer>> resultList = new LinkedList<>();

        oddTreeNodesStack.add(root);
        while(oddTreeNodesStack.size() != 0 || evenTreeNodesStack.size() != 0){
            List<Integer> integerList = new LinkedList<>();
            while (oddTreeNodesStack.size() != 0){
                TreeNode treeNode = oddTreeNodesStack.pop();
                integerList.add(treeNode.val);
                if(treeNode.left != null){
                    evenTreeNodesStack.push(treeNode.left);
                }
                if(treeNode.right != null){
                    evenTreeNodesStack.push(treeNode.right);
                }
            }
            if(integerList.size() != 0){
                resultList.add(integerList);
            }
            integerList = new LinkedList<>();
            while (evenTreeNodesStack.size() != 0){
                TreeNode treeNode = evenTreeNodesStack.pop();
                integerList.add(treeNode.val);
                if(treeNode.right != null){
                    oddTreeNodesStack.push(treeNode.right);
                }
                if(treeNode.left != null){
                    oddTreeNodesStack.push(treeNode.left);
                }
            }
            if(integerList.size() != 0){
                resultList.add(integerList);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        _103_BinaryTreeZigzagLevelOrderTraversal main = new _103_BinaryTreeZigzagLevelOrderTraversal();
        _103_BinaryTreeZigzagLevelOrderTraversal.TreeNode treeNode1 = main.new TreeNode(1);
        _103_BinaryTreeZigzagLevelOrderTraversal.TreeNode treeNode2 = main.new TreeNode(2);
        _103_BinaryTreeZigzagLevelOrderTraversal.TreeNode treeNode3 = main.new TreeNode(3);
        _103_BinaryTreeZigzagLevelOrderTraversal.TreeNode treeNode4 = main.new TreeNode(4);
        _103_BinaryTreeZigzagLevelOrderTraversal.TreeNode treeNode5 = main.new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        List<List<Integer>> list = main.zigzagLevelOrder(treeNode1);
        for(int i=0; i<list.size(); i++){
            for (int j=0; j<list.get(i).size(); j++){
                System.out.println(list.get(i).get(j));
            }
        }
    }
}


