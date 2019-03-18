package DataWhale.Leetcode;

/**
 * 在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class _0148_SortList {
    public ListNode sortList(ListNode head) {
        return head == null ? head : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode p = head, q = head, ppre = null;
        while (q != null && q.next != null) {
            ppre = p;
            p = p.next;
            q = q.next.next;
        }
        ppre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    // 利用归并排序思想
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
                cur.next = null;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        if (left != null)
            cur.next = left;
        if (right != null)
            cur.next = right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{4, 2, 1, 3});
        System.out.println(new _0148_SortList().sortList(head).toString());
    }
}
