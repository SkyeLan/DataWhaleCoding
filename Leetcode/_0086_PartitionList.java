package DataWhale.Leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class _0086_PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode pre = null, preCur = null, last = null, lastCur = null, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (pre == null) {
                    pre = cur;
                    cur = cur.next;
                    pre.next = null;
                    preCur = pre;
                } else {
                    preCur.next = cur;
                    cur = cur.next;
                    preCur = preCur.next;
                    preCur.next = null;
                }
            } else {
                if (last == null) {
                    last = cur;
                    cur = cur.next;
                    last.next = null;
                    lastCur = last;
                } else {
                    lastCur.next = cur;
                    cur = cur.next;
                    lastCur = lastCur.next;
                    lastCur.next = null;
                }
            }
        }
        if (pre != null) {
            head = pre;
            preCur.next = last;
        } else {
            head = last;
        }
        return head;
    }

    public static void main(String[] args) {
        int x = 3;
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(partition(head, x).toString());
    }
}
