package DataWhale.Task2;

/**
 * 循环队列
 */
public class CycleQueue {
    private int[] queue;
    private int front; // 头节点位置
    private int tail; // 指向第一个空的位置

    public CycleQueue(int capacity) {
        queue = new int[capacity];
        front = tail = 0;
    }

    public void enqueue(int num) {
        if (tail - front == queue.length - 1)
            throw new IndexOutOfBoundsException("队列满了");
        queue[tail++ % queue.length] = num;
    }

    public int dequeue() {
        if (tail - front == 0)
            throw new NullPointerException("队列空的");

        return queue[front++ % queue.length];
    }

    public int getFirst() {
        if (tail - front == 0)
            throw new NullPointerException("队列空的");
        return queue[front % queue.length];
    }

    public int getSize() {
        return tail - front;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append('[');
        for (int i = front; i < tail; i++) {
            res.append(queue[i % queue.length]);
            if (i != tail - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        CycleQueue aq = new CycleQueue(8);
        for (int i = 0; i < 10; i++) {
            aq.enqueue(i);
            System.out.println(aq);

            if (i % 3 == 0) {
                System.out.println("出队：" + aq.dequeue());
                System.out.println(aq);
            }
        }
        System.out.println("队首元素：" + aq.getFirst());
    }
}
