package DataWhale.Task6;

import Algorithm_Struction.Graph.Graph;
import Algorithm_Struction.Graph.ReadGraph;

import java.util.Vector;

// 稀疏图 - 邻接表
public class DenseGraph implements Graph {
    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private boolean[][] g; // 图的具体数据

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0; // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = new boolean[n][n];
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

        if (!directed)
            g[v][w] = g[w][v] = true;
        else
            g[v][w] = true;
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i++)
            if (g[v][i])
                adjV.add(i);
        return adjV;
    }

    // 显示图的信息
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(g[i][j] + "\t");
            System.out.println();
        }
    }
}
