package Tree;

/**
 * Created by sigong on 2018/9/6.
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        return getRootNode(inorder, 0, inLen-1, postorder, 0, postLen-1);
    }

    private TreeNode getRootNode(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = -1;
        for(int i=inEnd; i>=0; i--){
            if(postorder[postEnd] == inorder[i]){
                index = i;
                break;
            }
        }
        if (index == -1){
            return null;
        }

        root.left = getRootNode(inorder, inStart, index-1, postorder, postStart, postEnd-inEnd+index-1);
        root.right = getRootNode(inorder, index+1, inEnd, postorder, postEnd-inEnd+index, postEnd-1);

        return root;
    }

    public static void main(String[] args) {
        _106_ConstructBinaryTreefromInorderandPostorderTraversal main = new _106_ConstructBinaryTreefromInorderandPostorderTraversal();
        int[] post = {9,15,7,20,3};
        int[] in = {9,3,15,20,7};
        _106_ConstructBinaryTreefromInorderandPostorderTraversal.TreeNode treeNode= main.buildTree(in, post);
        System.out.println("haha");
    }
}
