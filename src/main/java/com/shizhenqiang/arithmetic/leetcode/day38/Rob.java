package com.shizhenqiang.arithmetic.leetcode.day38;


import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
        int i = rob.rob(new int[]{1, 2, 3, 1});
        System.out.println(i);
    }

    public int rob(int[] arr) {
        if (arr == null || arr.length == 0)return 0;
        else if (arr.length == 1)return arr[0];
        return Math.max(myRob(Arrays.copyOfRange(arr, 0, arr.length-1)), myRob(Arrays.copyOfRange(arr, 1, arr.length)));
    }

    private int myRob(int[] arr) {
        int pre = 0;
        int cur = 0, tmp;
        for (int num : arr) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
