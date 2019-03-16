package DataWhale.Task7;

import java.util.Scanner;

public class DP_package {

    public static void dp_package(int[] weight, int[] value, int packageWeight) {
        int numbers = weight.length;
        int[][] dp = new int[numbers + 1][packageWeight + 1];
        for (int i = 0; i <= numbers; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= packageWeight; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= numbers; i++) {
            for (int j = 1; j <= packageWeight; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (dp[i - 1][j] < dp[i - 1][j - weight[i - 1]] + value[i - 1])
                    dp[i][j] = dp[i - 1][j - weight[i - 1]] + value[i - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println("总价值：" + dp[numbers][packageWeight]);//输出背包能够装的最大价值
        int j = packageWeight;
        System.out.print("选中序号：");
        for (int i = numbers; i > 0; i--)
            if (dp[i][j] > dp[i - 1][j]) {
                System.out.print(i + "  ");//输出选中的物品的编号
                j = j - weight[i - 1];
                if (j < 0)
                    break;
            }
    }

    public static void main(String[] args) {
        //测试
        int[] w1 = {2, 2, 1, 5, 2, 3, 1};
        int[] p1 = {1, 3, 2, 5, 4, 2, 1};
        int c1 = 5;
        dp_package(w1, p1, c1);
    }
}

