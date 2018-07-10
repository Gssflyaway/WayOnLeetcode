package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sigong on 2018/7/4.
 */
public class _94_BinaryTreeInorderTraversal {

        //recursive
//        public List<Integer> inorderTraversal(TreeNode root) {
//                if (root == null)
//                        return new ArrayList<>();
//                List<Integer> integersList = new ArrayList<>();
//                integersList.addAll(inorderTraversal(root.left));
//                integersList.add(root.val);
//                integersList.addAll(inorderTraversal(root.right));
//                return integersList;
//        }

        //iterative inorder
        public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> integerList = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                stack.addAll(getInOrderLeftNodes(root));
                while (!stack.isEmpty()){
                        TreeNode tmp = stack.pop();
                        integerList.add(tmp.val);
                        if (tmp.right != null) {
                                stack.addAll(getInOrderLeftNodes(tmp.right));
                        }
                }
                return integerList;
        }

        private Stack<TreeNode> getInOrderLeftNodes(TreeNode treeNode){
                Stack<TreeNode> stack = new Stack<>();
                while (treeNode != null){
                        stack.push(treeNode);
                        if(treeNode.left == null){
                                break;
                        }
                        treeNode = treeNode.left;
                }
                return stack;
        }

        //preorder iterative
        public List<Integer> preorderTraversal(TreeNode root) {
                Stack<TreeNode> treeNodeStack = new Stack<>();
                List<Integer> integerList = new ArrayList<>();
                treeNodeStack.add(root);
                while (!treeNodeStack.isEmpty()){
                        TreeNode tmp = treeNodeStack.pop();
                        integerList.add(tmp.val);
                        if(tmp.right != null){
                                treeNodeStack.add(tmp.right);
                        }
                        if(tmp.left != null){
                                treeNodeStack.add(tmp.left);
                        }
                }
                return integerList;
        }

//        portorder recursive
//        public List<Integer> postOrderTraversal(TreeNode root) {
//                if (root == null)
//                        return new ArrayList<>();
//                List<Integer> integersList = new ArrayList<>();
//                integersList.addAll(posOrderTraversal(root.left));
//                integersList.addAll(posOrderTraversal(root.right));
//                integersList.add(root.val);
//                return integersList;
//        }

        //postorder iterative
//        public List<Integer> postOrderTraversal(TreeNode root) {
//                Stack<TreeNode> treeNodeStack = new Stack<>();
//                List<Integer> integerList = new ArrayList<>();
//                treeNodeStack.push(root);
//                while (!treeNodeStack.isEmpty()){
//                        TreeNode tmp = treeNodeStack.pop();
//                        integerList.add(0, tmp.val);
//                        if(tmp.left != null){
//                                treeNodeStack.push(tmp.left);
//                        }
//                        if (tmp.right != null){
//                                treeNodeStack.push(tmp.right);
//                        }
//                }
//                return integerList;
//        }

        public static void main(String[] args) {
                TreeNode a1 =  new TreeNode(1);
                TreeNode a2 =  new TreeNode(2);
                TreeNode a3 =  new TreeNode(3);
                TreeNode a4 =  new TreeNode(4);
                TreeNode a5 =  new TreeNode(5);
                TreeNode a6 =  new TreeNode(6);
                TreeNode a7 =  new TreeNode(7);
                TreeNode a8 =  new TreeNode(8);
                TreeNode a9 =  new TreeNode(9);
                TreeNode a10 =  new TreeNode(10);
                TreeNode a11 =  new TreeNode(11);
                a1.left = a2;
                a1.right = a3;
                a2.left = a4;
                a2.right = a5;
                a3.right = a6;
                a5.right = a7;
                a6.left = a8;
                a6.right = a9;
                a8.left = a10;
                a9.left = a11;
                _94_BinaryTreeInorderTraversal test = new _94_BinaryTreeInorderTraversal();
                List<Integer> result = test.inorderTraversal(a1);
//                List<Integer> result = test.preorderTraversal(a1);
//                List<Integer> result = test.postOrderTraversal(a1);
                for (Integer a:result
                     ) {
                        System.out.println(a);
                }
        }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
