package com.shizhenqiang.arithmetic.leetcode.firstWeek.threeSum;


import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;

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
public class ThreeSumFour {

    public static void main(String[] args) {

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSumOne(array);
        System.out.println(list);
    }

    private static List<List<Integer>> threeSumOne(int[] array) {
        if (array == null || array.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(array);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] > 0) break;
            if (i > 0 && array[i] == array[i - 1]) continue;
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == 0) {
                    lists.add(Arrays.asList(array[i], array[j], array[k]));
                    while (j < k && array[j] == array[j + 1]) j++;
                    while (j < k && array[k] == array[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) j++;
                else if (sum > 0) k--;
            }
        }
        return lists;
    }

}
