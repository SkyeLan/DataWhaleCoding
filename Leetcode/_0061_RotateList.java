package DataWhale.Leetcode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class _0061_RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        int i = 0, length = 0;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;
        cur = dummy;
        while (i < k && cur != null) {
            cur = cur.next;
            i++;
        }
        if (i < k)
            return head;
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = dummy.next;
        dummy.next = pre.next;
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3});
        int n = 4;
        System.out.println(rotateRight(head, n).toString());
    }
}
