package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.climbingStairs;


/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairsII {

    public static void main(String[] args) {
        ClimbingStairsII climbingStairsI = new ClimbingStairsII();
        int climbStairs = climbingStairsI.climbStairs(3);
        System.out.println(climbStairs);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(memo, n);
    }

    private int climb(int[] memo, int n) {
        if (memo[n] > 0) return memo[n];
        if (n <= 2) return n;
        else memo[n] = climb(memo, n - 1) + climb(memo, n - 2);
        return memo[n];
    }

}
