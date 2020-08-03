package com.shizhenqiang.arithmetic.leetcode.day01;


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
 */
public class ClimbStairsSix {

    public static void main(String[] args) {
        int a = climbStairsOne(44);
        System.out.println(a);
    }

    private static int climbStairsOne(int n) {
        int[] mem = new int[n + 1];
        return recursion(mem, n);
    }

    private static int recursion(int[] mem, int n) {
        if (mem[n] > 0) {
            return mem[n];
        }
        if (n <= 1) {
            return 1;
        } else if (n <= 2) {
            return 2;
        } else {
            mem[n] = recursion(mem, n - 1) + recursion(mem, n - 2);
        }
        return mem[n];
    }
}
