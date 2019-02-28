package DataWhale.Task1;

import Algorithm_Struction.Sort.InsertionSort;

/**
 * 大小固定的有序数组，支持动态增删改与合并操作
 */
public class Order_Array {
    private int[] data; // 数组存放的数据
    private int size; // 数组存放了多少数据,同时也是第一个空位置的索引
    private boolean ordered; // 受否有序

    // 无参数的构造函数，默认数组的容量capacity=10
    public Order_Array() {
        this(10);
    }

    // 构造函数，传入数组的容量capacity构造Array
    public Order_Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 查找所有number起始和结束的索引
    public int[] findAll(int number) {
        // 数组有序，使用二分查找的方法
        int index = find(number, 0, size - 1);
        int left = index, right = index;
        while (left - 1 > 0 && data[left - 1] == data[left])
            left--;
        while (right + 1 < size && data[right + 1] == data[left])
            right++;
        return new int[]{left, right};
    }

    // 二分查找法
    private int find(int number, int left, int right) {
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (data[mid] < number)
                return find(number, mid + 1, right);
            else if (data[mid] > number)
                return find(number, left, mid - 1);
            else {
                return mid;
            }
        }
        return -1;
    }

    public void add(int number) {
        if (size == data.length)
            throw new IllegalArgumentException("数组满了!");

        // 使用插入排序思想
        data[size++] = number;
        for (int j = size - 1; j > 0; j--)
            if (data[j - 1] > data[j]) {
                int temp = data[j - 1];
                data[j - 1] = data[j];
                data[j] = temp;
            } else
                break;
    }

    // 从数组中删除number
    public void delete(int number) {
        int[] indexes = findAll(number);
        if (indexes[0] == -1)
            System.out.println("数组中不存在" + number);
        else {
            for (int i = indexes[0]; i < size - indexes[1] + 1; i++)
                data[i] = data[indexes[1] + i - 1];
            size -= indexes[1] - indexes[0] + 1;
        }
    }


    // 将数组中的number1改为number2
    public void change(int number1, int number2) {
        int[] indexes = findAll(number1);
        if (indexes[0] == -1)
            System.out.println("数组中不存在" + number1);
        for (int i = indexes[0]; i < indexes[1] + 1; i++) {
            data[i] = number2;
        }
        // 改完后排序
        // 基本有序，使用插入排序
        insertSort();
    }

    // 插入排序
    private void insertSort() {
        for (int i = 1; i < size; i++)
            // 寻找合适的插入位置
            for (int j = i; j > 0; j--)
                if (data[j - 1] > data[j]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                } else
                    break;
    }

    // 合并两个有序数组
    public Order_Array merge(Order_Array a, Order_Array b) {
        Order_Array newArray = new Order_Array(a.size + b.size);
        int i = 0, j = 0;
        while (i < a.size && j < b.size)
            if (a.data[i] < b.data[j])
                newArray.data[newArray.size++] = a.data[i++];
            else
                newArray.data[newArray.size++] = b.data[j++];
        while (i < a.size)
            newArray.data[newArray.size++] = a.data[i++];
        while (j < b.size)
            newArray.data[newArray.size++] = b.data[j++];
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d.\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
