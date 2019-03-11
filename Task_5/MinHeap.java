package DataWhale.Task5;

public class MinHeap {
    private int currentSize;
    private int[] array;

    public MinHeap(int[] items) {
        currentSize = items.length;
        array = new int[currentSize + 1];
        int i = 1;
        for (int item : items)
            array[i++] = item;
        buildHeap();
    }

    private void percolateDown(int position) {
        int temp = array[position];
        int child;
        for (; position * 2 <= currentSize; position = child) {
            child = 2 * position;
            if (child != currentSize && array[child + 1] < (array[child]))
                child++;
            if (array[child] < (temp))
                array[position] = array[child];
            else
                break;
        }
        array[position] = temp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    public void insert(int x) {
        if (currentSize >= array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        while (hole > 1 && x < (array[hole / 2])) {
            array[hole] = array[hole / 2];
            hole /= 2;
        }
        array[hole] = x;
    }

    private void enlargeArray(int capacity) {
        int[] oldArr = array;
        int[] newArr = new int[capacity];
        for (int i = 1; i < array.length; i++)
            newArr[i] = oldArr[i];
        array = newArr;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int deleMin() {
        if (!isEmpty()) {
            int min = array[1];
            array[1] = array[currentSize--];
            percolateDown(1);
            return min;
        }
        return -1;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
            sb.append(array[i] + " ");
        return new String(sb);
    }
}
