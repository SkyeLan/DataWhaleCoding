package DataWhale.Leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class _0083_RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head;
        while (cur.next != null)
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 1, 1, 2, 2});
        System.out.println(deleteDuplicates(head).toString());
    }
}
