package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.sortedSquares;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/submissions/
 */
public class SortedSquares {

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] squares = sortedSquares.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(squares));
        int[] ints = sortedSquares.sortedSquaresII(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.pow(arr[i], 2);
        }
        Arrays.sort(arr);
        return arr;
    }

    public int[] sortedSquaresII(int [] arr) {
        int i = 0, j = arr.length-1, k = arr.length - 1;
        int [] ans = new int[arr.length];
        while (i <= j) {
            if (arr[i] + arr[j] < 0) {
                ans[k--] = arr[i] * arr[i];
                i++;
            } else  {
                ans[k--] = arr[j] * arr[j];
                j--;
            }
        }
        return ans;
    }
}
