package DataWhale.Task5;

import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;// 根节点
    private int count;// 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else
            node.right = insert(node.right, key, value);

        return node;
    }

    // 查看以node为根的二分搜索树中是否包含键值为key的节点
    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;
        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else
            return contain(node.right, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Node search(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key + " " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行前序遍历, 非递归算法
    private void preOrder2(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node newNode = st.pop();
            System.out.println(newNode.key + " " + newNode.value);
            if (newNode.right != null)
                st.push(newNode.right);
            if (newNode.left != null)
                st.push(newNode.left);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " " + node.value);
            inOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + " " + node.value);
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        // 我们使用LinkedList来作为我们的队列
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key + " " + node.value);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    // 寻找二分搜索树的最小的节点
    public Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大的节点
    public Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }
    
    // 从二分搜索树中删除键值为key的节点
    public void remove(Key key) {
        root = remove(root, key);
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 找到要删的节点了

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node s = new Node(minimum(node.right));
            s.right = removeMin(node.right);
            s.left = node.left;
            node.left = node.right = null;
            count--;
            return s;
        }
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = (int) (Math.random() * M);
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder(bst.root);
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder2
        System.out.println("preOrder2: ");
        bst.preOrder2(bst.root);
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder(bst.root);
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder(bst.root);
        System.out.println();

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }
}