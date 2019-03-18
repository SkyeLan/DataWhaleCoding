package DataWhale.Leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 */
public class _0019_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        int i = 0;
        while (i < n && cur != null) {
            cur = cur.next;
            i++;
        }
        if (i < n)
            return head;
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        int n = 1;
        System.out.println(removeNthFromEnd(head, n).toString());
    }
}
