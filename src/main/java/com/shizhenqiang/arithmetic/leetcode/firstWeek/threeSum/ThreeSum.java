package com.shizhenqiang.arithmetic.leetcode.firstWeek.threeSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSumOne(array);
        System.out.println(list);
    }

    private static List<List<Integer>> threeSumOne(int[] array) {
        if (array == null || array.length < 3) {
            return Collections.emptyList();
        }
        // 先进行排序，
        Arrays.sort(array);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) break;
            // 去重操作
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            // 三个索引指针，i、L、R
            /**
             *
             */
            int L = i + 1;
            int R = array.length - 1;
            while (L < R) {
                int sum = array[i] + array[L] + array[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(array[i], array[L], array[R]));
                    while (L < R && array[L] == array[L + 1]) L++; // 去重
                    while (L < R && array[R] == array[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return lists;
    }
}
