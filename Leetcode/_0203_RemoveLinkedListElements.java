package DataWhale.Leetcode;


/**
 * Remove all elements from a linked list of integers that have value val.
 */
public class _0203_RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        // 不要忘记对头结点的比较-----------------
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // ---------------------------------------
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 4, 5, 6};
        int val = 6;
        ListNode aa = new ListNode(a);
        System.out.println(removeElements(aa, val).toString());
    }
}
