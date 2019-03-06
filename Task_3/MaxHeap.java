package DataWhale.Task3;

public class MaxHeap {
    private int[] data;
    private int count;

    // 构造空堆，可以容纳 n 个元素
    public MaxHeap(int n) {
        data = new int[n + 1];
        count = 0;
    }

    public MaxHeap(int[] arr) {
        data = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            data[i + 1] = arr[i];
        count = arr.length;

        // 自底向上，对每个子树 shiftDown
        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int num) {
        data[++count] = num;
        shiftUp(count);
    }

    // 取出堆顶元素
    public int extractMax() {
        int gen = data[1];
        data[1] = data[count];
        data[count--] = -1;
        shiftDown(1);
        return gen;
    }

    private void shiftUp(int count) {
        while (count / 2 > 0 && data[count] > data[count / 2]) {
            swap(data, count, count / 2);
            count /= 2;
        }
    }

    private void shiftDown(int n) {
        int i = n, index;
        while (i * 2 <= count) {
            if (i * 2 + 1 <= count && data[i * 2 + 1] > data[i * 2])
                index = i * 2 + 1;
            else
                index = i * 2;
            if (data[i] < data[index]) {
                swap(data, i, index);
                i = index;
            } else
                break;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        for (int i = 0; i < 10; i++)
            maxHeap.insert(new Integer((int) (Math.random() * 100)));
        System.out.println(maxHeap.size());
        for (int i = 1; i <= 10; i++)
            System.out.print(maxHeap.data[i] + " ");
        System.out.println();
        System.out.println(maxHeap.extractMax());
        for (int i = 1; i <= 10; i++)
            System.out.print(maxHeap.data[i] + " ");
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
