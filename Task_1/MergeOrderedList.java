package DataWhale.Task1;

public class MergeOrderedList {
    class Node {
        int value;
        Node next;

        Node(int x) {
            value = x;
        }
    }

    /**
     * 合并两个有序数组
     */
    public Node MergeOrderedList(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node head = null;
        if (list1.value <= list2.value) {
            head = list1;
            head.next = MergeOrderedList(list1.next, list2);
        } else {
            head = list2;
            head.next = MergeOrderedList(list1, list2.next);
        }
        return head;
    }
}
