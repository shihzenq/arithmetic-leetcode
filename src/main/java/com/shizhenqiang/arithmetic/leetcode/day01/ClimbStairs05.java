package com.shizhenqiang.arithmetic.leetcode.day01;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs05 {

    public static void main(String[] args) {
        // 1、简单的方法
        int n = climbStairs(5);
        System.out.println("简单的方法:" + n);

        // 2、普通递归方法， 时间复杂度为O(2的n次方)， 空间复杂度为O（n）
        n = climbStairsOfRecursion(5);
        System.out.println("普通递归方法:" + n);

        // 3、记忆递归方法, 时间复杂度为O(n)， 空间复杂度为O（n）
        n = climbStairsOfRecursionMemory(5);
        System.out.println("记忆递归方法:" + n);

        // 4、 斐波那契数列通项公式 Binets Formula
        n = fibonacciSequence(5);
        System.out.println("斐波那契数列通项公式方法:" + n);
        // 5、矩阵方法
        n = matrixClimbStairs(5);
        System.out.println("矩阵方法：" + n);

        System.out.println(3 & 1);
        System.out.println(15 >> 1);
    }

    private static int matrixClimbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(n, q);
        return res[0][0];
    }

    private static int[][] pow(int n, int[][] q) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, q);
            }
            n >>= 1;
            q = multiply(q, q);
        }
        return ret;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    private static int fibonacciSequence(int n) {
        double sqrt = Math.sqrt(n);
        double r = Math.pow((1 + sqrt) / 2, n + 1) + Math.pow((1 - sqrt) / 2, n + 1);
        return (int) (r / sqrt);
    }

    private static int climbStairsOfRecursionMemory(int n) {
        int[] memo = new int[n + 1];
        return recursionMemory(n, memo);
    }

    private static int recursionMemory(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n <= 2) {
            return n;
        }
        memo[n] = recursionMemory(n - 1, memo) + recursionMemory(n - 2, memo);
        return memo[n];
    }

    private static int climbStairsOfRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairsOfRecursion(n - 1) + climbStairsOfRecursion(n - 2);
    }

    private static int climbStairs(int n) {
        int a, b = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = r;
            r = a + b;
        }
        return r;
    }


}
