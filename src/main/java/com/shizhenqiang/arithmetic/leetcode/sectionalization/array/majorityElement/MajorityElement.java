package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int element = majorityElement.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5});
        System.out.println(element);
        element = majorityElement.majorityElementTwo(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5});
        System.out.println(element);
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        int target = length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num)) {
                if (map.get(num) > target) {
                    return num;
                }
            }
        }
        return -1;
    }

    public int majorityElementTwo(int[] nums) {
        if (nums.length == 0) return -1;
        int res = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else count--;
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        int countForce = (nums.length >> 1) + 1;
        count = 0;
        for (int num : nums) {
            if (num == res) count++;
        }
        return count >= countForce ? res : -1;
    }


}
