package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day08;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Intersect {

    public static void main(String[] args) {
        int[] input = new int[]{4, 9, 5};
        int[] compare = new int[]{9, 4, 9, 8, 4};
        int[] a = intersectOne(input, compare);
        System.out.println(Arrays.toString(a));
        a = intersectTwo(input, compare);
        System.out.println(Arrays.toString(a));
        // 如果给定的数组已经排好序呢？你将如何优化你的算法
        a = intersectThree(input, compare);
        System.out.println(Arrays.toString(a));
    }

    // 如果给定的数组已经排好序呢？你将如何优化你的算法
    private static int[] intersectThree(int[] input, int[] compare) {
        if (input.length > compare.length) {
            return intersectThree(compare, input);
        }
        Arrays.sort(input);
        Arrays.sort(compare);
        int i =0;
        int j = 0;
        int k = 0;
        while (i < input.length && j < compare.length) {
            if (input[i] < compare[j]) {
                i++;
            } else if (input[i] > compare[j]) {
                j++;
            } else {
                input[k++] = input[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(input, 0, k);
    }

    private static int[] intersectTwo(int[] input, int[] compare) {
        if (input.length > compare.length) {
            return intersectTwo(compare, input);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for (int i : compare) {
            Integer integer = map.get(i);
            if (map.containsKey(i) && integer > 0) {
                input[k] = i;
                map.put(i, integer - 1);
                k++;
            }
        }
        return Arrays.copyOfRange(input, 0, k);
    }

    private static int[] intersectOne(int[] input, int[] compare) {
        if (input.length > compare.length) {
            return intersectOne(compare, input);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : compare) {
            Integer integer = map.get(i);
            if (map.containsKey(i) && integer > 0) {
                list.add(i);
                map.put(i, integer - 1);
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }


}
