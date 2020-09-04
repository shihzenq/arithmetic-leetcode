package com.shizhenqiang.arithmetic.leetcode.sectionalization.array;


/**
 *70. 爬楼梯
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
 *https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int stairs = climbStairs.climbStairs(5);
        System.out.println(stairs);
    }

    /**
     * 使用递归记忆法， 可以过滤已走过的
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int [] memo = new int[n + 1];
        return memo(memo, n);
    }

    private int memo(int[] memo, int n) {
        // termination
        if (memo[n] > 0) return memo[n];

        // process
        if (n <= 2) {
            return n;
        } else memo[n] = memo(memo, n -1) + memo(memo, n -2);
        return memo[n];
    }
}
