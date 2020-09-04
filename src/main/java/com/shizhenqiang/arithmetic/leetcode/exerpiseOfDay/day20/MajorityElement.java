package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * https://leetcode-cn.com/problems/majority-element/description/
 */
public class MajorityElement {

    public static void main(String[] args) {
       int a =  majorityElement(new int[] {2,2,1,1,1,2,2});
        System.out.println(a);
        a =  majorityElementTwo(new int[] {2,2,1,1,1,2,2});
        System.out.println(a);
        a =  majorityElementThree(new int[] {6,5,5});
        System.out.println(a);
    }

    private static int majorityElementThree(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int major = array[0];
        int count  =1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                major = array[i];
                count++;
            } else if (major == array[i]) {
                count++;
            } else count--;
        }
        return major;
    }

    private static int majorityElementTwo(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[array.length/2];
    }

    private static int majorityElement(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int majority = array.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxValue = Math.max(entry.getValue(), maxValue);
            if (maxValue > majority) {
                maxKey = entry.getKey();
                break;
            }
        }
        return maxKey;
    }
}
