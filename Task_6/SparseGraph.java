package DataWhale.Task6;

import Algorithm_Struction.Graph.Graph;
import Algorithm_Struction.Graph.ReadGraph;

import java.util.Vector;

public class SparseGraph implements Graph {
    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private Vector<Integer>[] g; // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0; // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++)
            g[i] = new Vector<Integer>();
    }

    // 返回节点个数
    public int V() {
        return n;
    }

    // 返回边的个数
    public int E() {
        return m;
    }

    // 向图中点V和点W之间添加一个边
    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;

        g[v].add(w);
        if (!directed)
            g[w].add(v);
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < g[v].size(); i++)
            if (g[v].elementAt((i)) == w)
                return true;
        return false;
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        return g[v];
    }

    // 显示图的信息
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++)
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }
}
