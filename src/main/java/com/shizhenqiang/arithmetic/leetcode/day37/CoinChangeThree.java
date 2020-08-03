package com.shizhenqiang.arithmetic.leetcode.day37;


import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChangeThree {

    public static void main(String[] args) {
        CoinChangeThree coinChange = new CoinChangeThree();
        int i = coinChange.coinChangeOne(new int[]{1, 2, 5}, 11);
        System.out.println(i);
        i = coinChange.coinChangeTwo(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }

    private int coinChangeTwo(int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        int sum = 0;
        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum < coin) break;
                if (dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : Math.min(temp, min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    private int coinChangeOne(int[] ints, int i) {
        return 0;
    }


}
