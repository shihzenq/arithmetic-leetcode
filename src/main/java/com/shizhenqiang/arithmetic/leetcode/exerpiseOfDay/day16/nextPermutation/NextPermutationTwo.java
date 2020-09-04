package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day16.nextPermutation;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutationTwo {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
//        nextPermutationOne(array);
//        System.out.println(Arrays.toString(array));
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    private static void nextPermutation(int[] array) {
        int changeIndex = array.length - 2;
        while (changeIndex >= 0) {
            if (array[changeIndex] < array[changeIndex + 1]) {
                break;
            }
            changeIndex--;
        }
        if (changeIndex < 0) {
            Arrays.sort(array);
            return;
        }
        int changeTarget = array.length - 1;
        while (array[changeTarget] <= array[changeIndex] && changeIndex < changeTarget) {
            changeTarget--;
        }
        if (changeIndex == changeTarget) {
            Arrays.sort(array);
            return;
        }
        int temp = array[changeIndex];
        array[changeIndex] = array[changeTarget];
        array[changeTarget] = temp;
        Arrays.sort(array, changeIndex + 1, array.length);
    }


}
