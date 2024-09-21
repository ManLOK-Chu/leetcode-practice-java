package coinChange2;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
//思路：完全背包问题
public class Solution {
    /**
     * 定义 dfs(i,c) 表示用前 i 种硬币组成金额 c 的方案数，考虑「选或不选」，有：
     * 不再继续选第 i 种硬币：dfs(i−1,c)。
     * 继续选一枚第 i 种硬币：dfs(i,c−coins[i])。
     * 根据加法原理，二者相加得：dfs(i,c) = dfs(i−1,c) + dfs(i,c−coins[i])
     * 递归边界：dfs(−1,0) = 1, dfs(−1,>0) = 0
     * 递归入口：dfs(n−1,amount)。
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dfs = new int[n + 1][amount + 1];
        dfs[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if (c < coins[i]) {
                    dfs[i + 1][c] = dfs[i][c];
                } else {
                    dfs[i + 1][c] = dfs[i][c] + dfs[i + 1][c - coins[i]];
                }
            }
        }
        return dfs[n][amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins1 = {1, 2, 5};
        System.out.println(solution.coinChange(coins1, 5));
        int[] coins2 = {2};
        System.out.println(solution.coinChange(coins2, 3));
        int[] coins3 = {10};
        System.out.println(solution.coinChange(coins3, 10));
    }
}
