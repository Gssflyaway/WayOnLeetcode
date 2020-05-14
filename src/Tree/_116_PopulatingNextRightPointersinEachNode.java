package Tree;

import java.util.LinkedList;

/**
 * Created by sigong on 2018/9/26.
 */

/*
* 这题默认的思路是用三个指针
* head的next始终指向每排第一个
* pre和cur在每一排递进
* */
public class _116_PopulatingNextRightPointersinEachNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = new TreeLinkNode(-1);
        head.next = root;

        while (head.next != null){
            TreeLinkNode pre = head;
            TreeLinkNode cur = head.next;
            head.next = null;
            while (cur != null){
                if (cur.left != null){
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        _116_PopulatingNextRightPointersinEachNode main = new _116_PopulatingNextRightPointersinEachNode();

        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t1 = main.new TreeLinkNode(1);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t2 = main.new TreeLinkNode(2);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t3 = main.new TreeLinkNode(3);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t4 = main.new TreeLinkNode(4);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t5 = main.new TreeLinkNode(5);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t6 = main.new TreeLinkNode(6);
        _116_PopulatingNextRightPointersinEachNode.TreeLinkNode t7 = main.new TreeLinkNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        main.connect_bak(t1);
    }

    public TreeLinkNode connect_bak(TreeLinkNode root) {
        if(root == null)
            return null;
        LinkedList<TreeLinkNode> nodeList = new LinkedList();

        nodeList.add(root);
        nodeList.add(null);
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;

        while (!nodeList.isEmpty()){
            TreeLinkNode tmp = nodeList.poll();
            if (tmp == null){
                if (pre == null)
                    break;
                pre = tmp;
                nodeList.offer(null);
            } else {
                cur = tmp;
                if (pre == null){
                    pre = tmp;
                } else {
                    pre.next = cur;
                    pre = cur;
                }
                if (tmp.left != null)
                    nodeList.offer(tmp.left);
                if (tmp.right != null)
                    nodeList.offer(tmp.right);
            }
        }
        return root;
    }
}
