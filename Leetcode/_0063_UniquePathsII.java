package DataWhale.Leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 */
public class _0063_UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    path[0][0] = obstacleGrid[i][j] == 1 ? 0 : 1;
                } else if (i == 0) {
                    if (obstacleGrid[i][j] == 1 || path[i][j - 1] == 0)
                        path[i][j] = 0;
                    else
                        path[i][j] = 1;
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 1 || path[i - 1][j] == 0)
                        path[i][j] = 0;
                    else
                        path[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1)
                        path[i][j] = 0;
                    else
                        path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
