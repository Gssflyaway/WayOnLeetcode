package DP;

import java.util.ArrayList;
import java.util.List;

/*
* 这题是96题卡特兰树的姐妹题
* 要求1-n的数字为节点的二叉排序树有多少种，很容易想到分别用1-n做顶点
* 然后左右子树分治，然后重复这个流程就可以了。然后递归的结果就是把子树的头结点返回给上一层
*
* */
public class _95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<>();

        return handle(1, n);
    }

    private List<TreeNode> handle(int start, int end){
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (start > end) {
            treeNodeList.add(null);
            return treeNodeList;
        }else if (start == end){
            treeNodeList.add(new TreeNode(start));
            return treeNodeList;
        }
        for (int i=start; i<=end; i++){
            List<TreeNode> left = handle(start, i-1);
            List<TreeNode> right = handle(i+1, end);
            for (int j=0; j<left.size(); j++){
                for (int k=0; k<right.size(); k++){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left.get(j);
                    treeNode.right = right.get(k);
                    treeNodeList.add(treeNode);
                }
            }
        }
        return treeNodeList;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
