package DataWhale.Task2;

/**
 * 用数组实现一个队列
 */
public class ArrayQueue {
    private int[] queue;
    private int size;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
    }

    public void enqueue(int num) {
        if (size == queue.length)
            throw new IndexOutOfBoundsException("队列满了");
        queue[size++] = num;
    }

    public int dequeue() {
        if (size == 0)
            throw new NullPointerException("队列空的");
        int temp = queue[0];
        for (int i = 1; i < size; i++)
            queue[i - 1] = queue[i];
        size--;
        return temp;
    }

    public int getFirst() {
        if (size == 0)
            throw new NullPointerException("队列空的");
        return queue[0];
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(queue[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
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
