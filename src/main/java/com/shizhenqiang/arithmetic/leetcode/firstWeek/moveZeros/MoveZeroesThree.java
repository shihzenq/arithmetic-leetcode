package com.shizhenqiang.arithmetic.leetcode.firstWeek.moveZeros;

import java.util.Arrays;

/**
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroesThree {

    public static void main(String[] args) {

        int[] array = new int[]{0, 1, 0, 3, 12};
        int[] a = moveZerosOneMethod(array);
        System.out.println(Arrays.toString(a));
    }

    private static int[] moveZerosOneMethod(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && j != i) {
                array[j] = array[i];
                array[i] = 0;
                j ++;
            }

        }
        return array;
    }

}
