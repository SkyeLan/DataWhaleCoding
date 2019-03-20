package DataWhale.Leetcode;

import java.util.*;

/**
 * In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is
 * impossible, return -1 instead.
 * <p>
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class _0994_RottingOranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> lan = new LinkedList<>();  // 存放腐烂的橘子
        int row = grid.length, col = grid[0].length;
        int times = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] == 2)
                    lan.add(new int[]{i, j, times});    // 第三个位置存放第几轮变为腐烂

        int[][] direct = new int[][]{{0, -1}, {1, 0}, {-1, 0}, {0, 1}};    // 上、下、左、右
        while (!lan.isEmpty()) {
            int[] pre = lan.poll();
            for (int[] d : direct) {
                int x = pre[0] + d[0];
                int y = pre[1] + d[1];
                if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    lan.add(new int[]{x, y, pre[2] + 1});
                }
            }
            if (lan.isEmpty())
                times = pre[2];
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] == 1)
                    return -1;
        return times;
    }

    public static void main(String[] args) {
        int[][] orange = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(orange));
    }
}
