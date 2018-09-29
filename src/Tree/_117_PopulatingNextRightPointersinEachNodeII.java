package Tree;

/**
 * Created by sigong on 2018/9/9.
 */
public class _117_PopulatingNextRightPointersinEachNodeII {
    class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode nextLevelHead = new TreeLinkNode(-1);
        nextLevelHead.next = root;
        while (nextLevelHead.next != null){
            TreeLinkNode pre = nextLevelHead;
            TreeLinkNode cur = nextLevelHead.next;
            nextLevelHead.next = null;
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
        _117_PopulatingNextRightPointersinEachNodeII main = new _117_PopulatingNextRightPointersinEachNodeII();

        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t1 = main.new TreeLinkNode(1);
        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t2 = main.new TreeLinkNode(2);
        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t3 = main.new TreeLinkNode(3);
        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t4 = main.new TreeLinkNode(4);
        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t5 = main.new TreeLinkNode(5);
        _117_PopulatingNextRightPointersinEachNodeII.TreeLinkNode t7 = main.new TreeLinkNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;

        main.connect(t1);
    }
}
