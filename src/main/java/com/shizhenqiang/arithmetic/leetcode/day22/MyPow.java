package com.shizhenqiang.arithmetic.leetcode.day22;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {
    public static void main(String[] args) {

        // 2.00000
        //-2147483648
        double a = pow(2.00000, -2147483648);
        System.out.println(a);
    }

    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
