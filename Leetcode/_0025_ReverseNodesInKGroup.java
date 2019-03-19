package DataWhale.Leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of
 * nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class _0025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode reversePre = dummy;
        int i = 0;
        ListNode rever = new ListNode(-1);
        ListNode cur2 = rever;
        while (head != null) {
            while (i < k) {
                if (head == null) {
                    reversePre.next = rever.next;
                    return dummy.next;
                }
                cur2.next = head;
                head = head.next;
                cur2 = cur2.next;
                cur2.next = null;
                i++;
            }
            reverse(rever);
            reversePre.next = rever.next;
            while (reversePre.next != null)
                reversePre = reversePre.next;
            cur2 = rever;
            i = 0;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode dummy) {
        // 翻转链表 --------------
        ListNode temp, rever = null, cur = dummy.next;
        while (cur != null) {
            temp = cur.next;
            cur.next = rever;
            rever = cur;
            cur = temp;
        }
        dummy.next = rever;
        // -----------------------
        return dummy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3});
        int k = 3;
        System.out.println(new _0025_ReverseNodesInKGroup().reverseKGroup(head, k).toString());
    }
}
