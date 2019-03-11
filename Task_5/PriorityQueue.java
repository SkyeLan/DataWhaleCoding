package DataWhale.Task5;


class PriorityQueue {
    private int maxSize;
    private int[] queArray;
    private int nItems;

    public PriorityQueue(int capacity) {
        maxSize = capacity;
        queArray = new int[capacity];
        nItems = 0;
    }

    public void insert(int item) {
        int j;
        if (nItems == 0)
            queArray[nItems++] = item;
        else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j])
                    queArray[j + 1] = queArray[j];
                else
                    break;
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public int remove() {
        return queArray[--nItems];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}

class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(33);
        pq.insert(30);
        pq.insert(32);
        pq.insert(31);
        while (!pq.isEmpty())
            System.out.println(pq.remove() + "");
    }
}