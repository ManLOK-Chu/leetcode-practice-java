package bestTimeToBuyAndSellStock;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution {
    //动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        int minPrice = prices[0];
        for (int i = 2; i <= n; i++) {
            minPrice = Math.min(minPrice, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - minPrice);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices1));
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices2));
    }
}
