package DataWhale.Leetcode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class _0092_ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode hold = null, rever = null, cur = head, last = null;
        int i = 0;
        while (cur != null) {
            i++;
            if (i >= m && i <= n) {
                if (i == m)
                    last = cur;
                ListNode node = cur;
                cur = cur.next;
                node.next = rever;
                rever = node;
            } else if (i < m) {
                hold = cur;
                cur = cur.next;
            } else
                break;
        }
        if (hold != null)
            hold.next = rever;
        else
            head = rever;
        last.next = cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 5});
        int m = 1, n = 2;
        System.out.println(reverseBetween(head, m, n).toString());
    }
}
