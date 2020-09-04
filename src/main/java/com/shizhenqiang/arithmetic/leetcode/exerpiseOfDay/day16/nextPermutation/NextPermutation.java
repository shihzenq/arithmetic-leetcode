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
public class NextPermutation {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
//        nextPermutationOne(array);
//        System.out.println(Arrays.toString(array));
        nextPermutationTwo(array);
        System.out.println(Arrays.toString(array));
    }

    private static void nextPermutationTwo(int[] nums) {
        int changeIndex = nums.length - 2;
        while (changeIndex >= 0){
            if (nums[changeIndex] < nums[changeIndex+1]){
                break;
            }
            changeIndex --;
        }
        if (changeIndex < 0){
            Arrays.sort(nums);
            return;
        }

        int changeTarget = nums.length - 1;
        while (nums[changeTarget] <= nums[changeIndex] && changeIndex < changeTarget){
            changeTarget --;
        }
        if (changeTarget == changeIndex){
            Arrays.sort(nums);
            return;
        }
        int tmp = nums[changeIndex];
        nums[changeIndex] = nums[changeTarget];
        nums[changeTarget] = tmp;
        Arrays.sort(nums,changeIndex+1,nums.length);
    }

    private static void nextPermutationOne(int[] array) {
        if (array.length < 2) {
            return;
        }
        int length = array.length;
        int index = length - 1;
        while (index > 0) {
            if (array[index - 1] < array[index]) {
                break;
            }
            index--;
        }
        if (index == 0) {
            reverseSortOne(array, 0, length - 1);
        } else {
            int val = array[index - 1];
            int j = length - 1;
            while (j >= index) {
                if (array[j] > val) {
                    break;
                }
                j--;
            }
            swapOne(array, j, index - 1);
            reverseSortOne(array, index, length - 1);
        }
        return;
    }

    private static void reverseSortOne(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        for (int i = start; i <= (start + end) / 2; i++) {
            swapOne(array, i, start + end - i);
        }
    }

    private static void swapOne(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n < 2)
            return;
        int index = n - 1;
        while (index > 0) {
            if (num[index - 1] < num[index])
                break;
            index--;
        }
        if (index == 0) {
            reverseSort(num, 0, n - 1);
            return;
        } else {
            int val = num[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (num[j] > val)
                    break;
                j--;
            }
            swap(num, j, index - 1);
            reverseSort(num, index, n - 1);
            return;
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = 0;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void reverseSort(int[] num, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }
}
