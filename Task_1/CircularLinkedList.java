package DataWhale.Task1;

public class CircularLinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        dummyHead = new Node();
        tail = new Node();
        tail.next = dummyHead;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表的index位置添加新的元素e
    public void add(int index, E e) {
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.next = new Node(e, pre.next);
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        tail.next = new Node(e, dummyHead);
        tail = tail.next;
        size++;
    }

    // 获得链表的第index个位置的元素
    public E get(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return tail.e;
    }

    // 修改链表的第index个位置的元素为e
    public void set(int index, E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;

        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;

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

    // 从链表中删除元素e
    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e))
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }
}

