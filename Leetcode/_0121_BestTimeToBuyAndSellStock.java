package DataWhale.Leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
public class _0121_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int minIndex = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minIndex = prices[minIndex] < prices[i] ? minIndex : i;
            profit = prices[i] - prices[minIndex] > profit ? prices[i] - prices[minIndex] : profit;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
