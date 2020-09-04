package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day12;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroesFour {

    public static void main(String[] args) {
        int[] a = moveZeroOne(new int[]{0, 1, 0, 3, 12});
        System.out.println(Arrays.toString(a));
    }

    private static int[] moveZeroOne(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (j != i) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                }
                j++;
            }
        }

        return arr;
    }

}
