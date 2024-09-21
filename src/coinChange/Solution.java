package coinChange;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
//思路：完全背包问题
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if (c < coins[i]) {
                    dp[i + 1][c] = dp[i][c];
                } else {
                    dp[i + 1][c] = Math.min(dp[i][c], dp[i + 1][c - coins[i]] + 1);
                }
            }
        }
        int res = dp[n][amount];
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins1 = {1, 2, 5};
        System.out.println(solution.coinChange(coins1, 11));
        int[] coins2 = {2};
        System.out.println(solution.coinChange(coins2, 3));
        int[] coins3 = {1};
        System.out.println(solution.coinChange(coins3, 0));
    }
}
