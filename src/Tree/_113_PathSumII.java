package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigong on 2018/9/8.
 */
public class _113_PathSumII {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return new ArrayList<>();

        return checkNodes(root, 0, sum);
    }

    private List<List<Integer>> checkNodes(TreeNode root, int nodeSum, int sum){
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        if (root.left == null && root.right == null){
            nodeSum += root.val;
            if (nodeSum == sum){
                numberList.add(root.val);
                resultList.add(numberList);
            }
            return resultList;
        }

        if (root.left != null) {
            resultList.addAll(checkNodes(root.left, nodeSum + root.val, sum));
        }
        if (root.right != null) {
            resultList.addAll(checkNodes(root.right, nodeSum + root.val, sum));
        }
        if(resultList.size() != 0){
            for (List<Integer> list:resultList){
                list.add(0, root.val);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        _113_PathSumII main = new _113_PathSumII();

        _113_PathSumII.TreeNode t1 = main.new TreeNode(5);
        _113_PathSumII.TreeNode t2 = main.new TreeNode(4);
        _113_PathSumII.TreeNode t3 = main.new TreeNode(8);
        _113_PathSumII.TreeNode t4 = main.new TreeNode(11);
        _113_PathSumII.TreeNode t5 = main.new TreeNode(13);
        _113_PathSumII.TreeNode t6 = main.new TreeNode(4);
        _113_PathSumII.TreeNode t7 = main.new TreeNode(7);
        _113_PathSumII.TreeNode t8 = main.new TreeNode(2);
        _113_PathSumII.TreeNode t9 = main.new TreeNode(1);
        _113_PathSumII.TreeNode t10 = main.new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.right = t9;
        t6.left = t10;

        List<List<Integer>> resultList = main.pathSum(t1, 22);

        for(int i=0; i<resultList.size(); i++){
            for (int j=0; j<resultList.get(i).size(); j++){
                System.out.print(resultList.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
