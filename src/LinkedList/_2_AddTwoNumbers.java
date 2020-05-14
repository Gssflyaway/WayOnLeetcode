package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        if (l1.next == null && l1.val == 0)
            return l2;
        if (l2.next == null && l2.val == 0)
            return l1;

        int newVal = 0, nextVal = 0;
        ListNode preNode = null, head = null;
        while (true) {
            int val = l1.val + l2.val + nextVal;
            newVal = val % 10;
            nextVal = val / 10;
            ListNode listNode = new ListNode(newVal);
            if (preNode == null) {
                head = listNode;
            } else {
                preNode.next = listNode;
            }
            preNode = listNode;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null || l2 == null)
                break;
        }
        ListNode temp = l1 == null ? l2 : l1;
        if (temp == null && nextVal > 0){
            ListNode listNode = new ListNode(nextVal);
            preNode.next = listNode;
            return head;
        }
        while (temp != null) {
            int val = temp.val + nextVal;
            newVal = val % 10;
            nextVal = val / 10;
            ListNode listNode = new ListNode(newVal);
            preNode.next = listNode;
            preNode = listNode;
            temp = temp.next;
        }
        if (nextVal > 0){
            ListNode listNode = new ListNode(nextVal);
            preNode.next = listNode;
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(8);
        listNode2.next = listNode3;
        new _2_AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
