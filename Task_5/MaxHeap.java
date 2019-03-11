package DataWhale.Task5;

public class MaxHeap {
    private int[] array;
    private int currentSize;

    public MaxHeap(int[] arr) {
        currentSize = arr.length;
        array = new int[currentSize + 1];
        int i = 1;
        for (int j = 0; j < arr.length; j++)
            array[i++] = arr[j];
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i <= currentSize; i++)
            percolateUp(i);
    }

    private void percolateUp(int position) {
        int temp = array[position];
        while (position > 1) {
            if (array[position / 2] < (temp)) {
                array[position] = array[position / 2];
                position /= 2;
            } else
                break;
        }
        array[position] = temp;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public int deleMax() {
        int max = array[1];
        int temp = array[currentSize--];
        int position = 1;
        int child;
        while (position * 2 <= currentSize) {
            child = 2 * position;
            if (child != currentSize && array[child] < array[child + 1])
                child++;
            if (array[child] > temp)
                array[position] = array[child];
            else
                break;
            position = child;
        }
        array[position] = temp;
        return max;
    }

    public void insert(int x) {
        if (currentSize == array.length - 1)
            enlargeArray(2 * currentSize + 1);
        array[++currentSize] = x;
        percolateUp(currentSize);
    }

    private void enlargeArray(int capacity) {
        int[] oldArr = array;
        int[] newArr = new int[capacity];
        for (int i = 1; i < array.length; i++)
            newArr[i] = oldArr[i];
        array = newArr;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
            sb.append(array[i] + " ");
        return new String(sb);
    }

}
