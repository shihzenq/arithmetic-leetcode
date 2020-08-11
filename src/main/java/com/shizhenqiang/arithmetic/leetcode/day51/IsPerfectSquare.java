package com.shizhenqiang.arithmetic.leetcode.day51;


/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        boolean perfectSquare = isPerfectSquare.isPerfectSquare(14);
        System.out.println(perfectSquare);
        boolean perfectSquareTwo = isPerfectSquare.isPerfectSquareTwo(16);
        System.out.println(perfectSquareTwo);
    }

    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquareTwo(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int res = num /mid, remain = num % mid;
            if (res == mid && remain == 0) return true;
            if (res < mid) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }
}
