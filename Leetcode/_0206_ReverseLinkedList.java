package DataWhale.Leetcode;

/**
 * Reverse a singly linked list.
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _0206_ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode head2 = new ListNode();
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = head2;
            head2 = node;
        }
        return head2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseList(head).toString());
    }
}
