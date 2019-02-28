package DataWhale.Task1;

public class DoubleLinkedList<E> {
    private class Node {
        public E e;
        public Node pre;
        public Node next;

        public Node(E e, Node pre, Node next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public DoubleLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // 在链表的index位置添加新的元素e
    public void add(int index, E e) {
        Node temp = new Node(e);
        Node pre = dummyHead;
        if (size != 0) {
            for (int i = 0; i < index; i++)
                pre = pre.next;
            pre.next.pre = temp;
            temp.next = pre.next;
            temp.pre = pre;
            pre.next = temp;
            size++;
        } else {
            pre.next = temp;
            temp.pre = pre;
            size++;
        }
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 从链表中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        Node delNode = pre.next;
        if (delNode.next != null) {
            delNode.next.pre = pre;
            pre.next = delNode.next;

            delNode.next = null;
            delNode.pre = null;
            size--;
        } else {
            pre.next = null;
            delNode.next = null;
            delNode.pre = null;
            size--;
        }

        return delNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }
}
