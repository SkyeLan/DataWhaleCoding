package DataWhale.Task4;

/**
 * 基于链表法解决冲突问题的散列表
 */
public class ChainingHashSet<K, V> {
    private int num; // 当前散列表中的键值对总数
    private int capacity; // 散列表的大小
    private SeqSearchST<K, V>[] st;   // 链表对象数组

    // SeqSearchST基于链表的符号表实现
    class SeqSearchST<K, V> {
        private Node first;

        // 结点类
        private class Node {
            K key;
            V value;
            Node next;

            // 构造函数
            public Node(K key, V val, Node next) {
                this.key = key;
                this.value = val;
                this.next = next;
            }
        }

        // put()方法
        public void put(K key, V value) {
            // 先查找表中是否已经存在相应的key
            for (Node node = first; node != null; node = first.next)
                if (key.equals(key)) {
                    node.value = value;  // 如果key存在，就把当前value插入node.next中
                    return;
                }
            // 表中不存在相应的key，直接插入表头
            first = new Node(key, value, first);
        }

        // get()方法
        public V get(K key) {
            for (Node node = first; node != null; node = first.next)
                if (key.equals(node.key))
                    return node.value;
            return null;
        }
    }

    // 构造函数
    public ChainingHashSet(int initialCapacity) {
        num = 0;
        capacity = initialCapacity;
        st = (SeqSearchST<K, V>[]) new Object[initialCapacity];
        for (int i = 0; i < initialCapacity; i++)
            st[i] = new SeqSearchST<>();
    }

    // hash()方法
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(K key, V value) {
        st[hash(key)].put(key, value);
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }
}
