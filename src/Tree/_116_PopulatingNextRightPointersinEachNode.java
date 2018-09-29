package Tree;

/**
 * Created by sigong on 2018/9/26.
 */
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
        t1.left = t2;
        t1.right = t3;

        main.connect(t1);
    }
}
