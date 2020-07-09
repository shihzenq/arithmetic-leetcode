package com.shizhenqiang.arithmetic.leetcode.day17;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Intersection {

    public static void main(String[] args) {
        int[] a = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println(Arrays.toString(a));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i =0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
