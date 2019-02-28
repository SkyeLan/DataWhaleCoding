package DataWhale.Task1;

/**
 * 动态扩容数组
 * Dynamic expansion array
 * 主要是 resize() 函数的作用
 * @param <E>
 */
public class DE_Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public DE_Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public DE_Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Error. Require index >= 0 and index <= size.");
        //---------- 扩容 ------------------------------
        if (size == data.length)
            resize(2 * data.length);
        //----------------------------------------------
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
        data[index] = e;
        size++;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(e, size);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(e, 0);
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Error. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(E e, int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Error. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return true;
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(Object e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return i;
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Error. Index is illegal.");
        E ret = data[index];
        //---------- 缩容 ------------------------------
        // Lazy 缩容，防止频繁增删
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        //----------------------------------------------
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1)
            remove(index);
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

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
