package Tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by sigong on 2018/9/4.
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen == 0 || inLen == 0)
            return null;

//        TreeNode root = new TreeNode(preorder[0]);
//        int rootIndex = -1;
//        for (int i=0; i<inLen; i++){
//            if (inorder[i] == preorder[0]){
//                rootIndex = i;
//                break;
//            }
//        }
//        if(rootIndex == -1){
//            return null;
//        }
//
//
//
//        root.left = generateRootOfChildTree(preorder, 1, rootIndex+1, inorder, 0, rootIndex-1);
//        root.right = generateRootOfChildTree(preorder, rootIndex+2, preLen-1, inorder, rootIndex+1, inLen-1);

        return generateRootOfChildTree(preorder, 0, preLen-1, inorder, 0, inLen-1);
    }

    private TreeNode generateRootOfChildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = -1;
        for (int i=inStart; i<=inEnd; i++){
            if (inorder[i] == preorder[preStart]){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }

        root.left = generateRootOfChildTree(preorder, preStart+1, rootIndex-inStart+preStart, inorder, inStart, rootIndex-1);
        root.right = generateRootOfChildTree(preorder, rootIndex-inStart+preStart+1, preEnd, inorder, rootIndex+1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTreefromPreorderandInorderTraversal main = new _105_ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        _105_ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode treeNode= main.buildTree(pre, in);
        System.out.println("haha");
    }
}
