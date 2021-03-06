package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day32;


/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int maxFor = nums[0], maxHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxHere  = Math.max(maxHere + nums[i], nums[i]);
            maxFor = Math.max(maxFor, maxHere);
        }
        return maxFor;
    }
}
