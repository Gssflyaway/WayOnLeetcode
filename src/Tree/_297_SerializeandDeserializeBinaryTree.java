package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sigong on 2018/9/29.
 */
public class _297_SerializeandDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        StringBuffer stringBuffer = new StringBuffer("[");
        while (!treeNodeQueue.isEmpty()){
            TreeNode treeNode = treeNodeQueue.poll();
            if (treeNode == null){
                stringBuffer.append("null");
            }else {
                treeNodeQueue.add(treeNode.left);
                treeNodeQueue.add(treeNode.right);
                stringBuffer.append(treeNode.val);
            }
            if (!treeNodeQueue.isEmpty()){
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)){
            return null;
        }

        String treeString = data.substring(1, data.length());
        String[] nodeArray = treeString.split(",");
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodeArray[0]));
        nodeQueue.add(root);
        int arrayIndex = 1;
        while (arrayIndex <  nodeArray.length){
            TreeNode parent = nodeQueue.poll();
            if (!"null".equals(nodeArray[arrayIndex])){
                TreeNode treeNode = new TreeNode(Integer.valueOf(nodeArray[arrayIndex]));
                nodeQueue.add(treeNode);
                parent.left = treeNode;
            }
            arrayIndex++;
            if (!"null".equals(nodeArray[arrayIndex])){
                TreeNode treeNode = new TreeNode(Integer.valueOf(nodeArray[arrayIndex]));
                nodeQueue.add(treeNode);
                parent.right = treeNode;
            }
            arrayIndex++;
        }
        return root;
    }
}
