package DataWhale.Leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you
 * like (ie, buy one and sell one share of the stock multiple times) with the following
 * restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock
 * before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */

public class _0309_BestTimeToBuyAndSellStockWithCooldown {
    // 设置一个sell[i]数组表示前i天交易，最后一次为卖获得的最大利润。
    // 设置一个buy[i]数组表示前i天交易，最后一次为买获得的最大利润。
    // 转移方程为：
    // sell[i] = max()
    // buy[i] = max()
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length < 2)
            return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = Math.max(i - 2 >= 0 ? sell[i - 2] - prices[i] : -prices[i], buy[i - 1]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
