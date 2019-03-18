package DataWhale.Leetcode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class _0143_ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy.next, fast = dummy.next.next;
        // 找到中间节点 ----------
        while (fast != null && fast.next != null) {
            slow = slow.next;  // 最终的slow相当于后半段的虚拟头结点
            fast = fast.next.next;
        }
        // 翻转链表 --------------
        ListNode temp, rever = null, cur = slow.next;
        while (cur != null) {
            temp = cur.next;
            cur.next = rever;
            rever = cur;
            cur = temp;
        }
        slow.next = rever;
        // -----------------------
        cur = dummy;
        ListNode l2 = slow.next;
        slow.next = null;
        while (l2 != null) {
            ListNode temp1 = head, temp2 = l2;
            head = head.next;
            l2 = l2.next;
            temp1.next = null;
            temp2.next = null;
            cur.next = temp1;
            cur.next.next = temp2;
            cur = cur.next.next;
        }
        cur.next = head;
        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        reorderList(head);
        System.out.println(head.toString());
    }
}
