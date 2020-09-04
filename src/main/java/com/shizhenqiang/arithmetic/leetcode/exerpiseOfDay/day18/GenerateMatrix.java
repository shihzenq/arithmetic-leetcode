package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day18;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class GenerateMatrix {

    public static void main(String[] args) {

        int[][] a = generateMatrix(3);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(a));
    }

    private static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        int[][] mar = new int[n][n];
        while (num <= tar) {
            for (int i = l; i <= r; i++) mar[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) {
                mar[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                mar[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                mar[i][l] = num++;
            }
            l++;
        }

        return mar;
    }
}
