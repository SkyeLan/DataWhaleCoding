package DataWhale.Leetcode;

/**
 * Sort a linked list using insertion sort. *
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs
 * within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 */
public class _0147_InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur;
        while (head != null) {
            cur = dummy;
            while (cur.next != null && cur.next.val < head.val)
                cur = cur.next;
            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{4, 2, 1, 3});
        System.out.println(insertionSortList(head).toString());
    }
}
