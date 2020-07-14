package com.shizhenqiang.arithmetic.leetcode.day22;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

    public static void main(String[] args) {

        int a = findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(a);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (j == k) {
                return nums[i];
            }
            j++;
        }

        return 0;
    }
}
