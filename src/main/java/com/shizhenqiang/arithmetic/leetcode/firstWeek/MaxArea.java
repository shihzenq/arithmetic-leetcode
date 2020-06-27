package com.shizhenqiang.arithmetic.leetcode.firstWeek;

/**
 * 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    public static void main(String[] args) {

        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int a = maxAreaOne(array);
        System.out.println(a);

        a = maxAreaTwo(array);
        System.out.println(a);
    }

    private static int maxAreaTwo(int[] array) {
        int max = 0;
        for (int i = 0, j = array.length - 1; i < j; ) {
            int minHeight = array[i] <  array[j] ? array[i++] : array[j--];
            int area = (j - i +1) * minHeight;
            max = Math.max(area, max);
        }
        return max;
    }

    private static int maxAreaOne(int[] array) {
        // 求最大面试， 并且i和j不相等
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int area = (j - i) * Math.min(array[i], array[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
