package DataWhale.Leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be
 * made by splicing together the nodes of the first two lists.
 */
public class _0021_MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null, cur = node;
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
                temp.next = null;
            } else {
                temp = l2;
                l2 = l2.next;
                temp.next = null;
            }
            if (node == null) {
                node = temp;
                cur = node;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        while (l1 != null) {
            ListNode temp = l1;
            l1 = l1.next;
            temp.next = null;
            if (node == null) {
                node = temp;
                cur = node;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        while (l2 != null) {
            ListNode temp = l2;
            l2 = l2.next;
            temp.next = null;
            if (node == null) {
                node = temp;
                cur = node;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        System.out.println(mergeTwoLists(l1, l2).toString());
    }
}
