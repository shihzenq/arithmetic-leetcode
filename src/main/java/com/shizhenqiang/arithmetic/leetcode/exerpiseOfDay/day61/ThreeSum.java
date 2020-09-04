package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target == 0) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (target < 0) j++;
                else k--;
            }
        }

        return lists;
    }
}
