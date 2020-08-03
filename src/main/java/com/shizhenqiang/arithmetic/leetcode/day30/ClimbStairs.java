package com.shizhenqiang.arithmetic.leetcode.day30;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(5);
        System.out.println(i);
    }

    /**
     * 斐波那契数列
     * f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int [] memo = new int[n + 1];
        return climbMemo(memo, n);
    }

    private int climbMemo(int[] memo, int n) {
        // termination
        // 不做重复运算
        if (memo[n] > 0) {
            return memo[n];
        }
        // process
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else memo[n] = climbMemo(memo, n -1) + climbMemo(memo, n -2);
        return memo[n];
    }
}
