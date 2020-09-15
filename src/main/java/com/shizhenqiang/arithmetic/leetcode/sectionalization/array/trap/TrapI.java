package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.trap;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class TrapI {

    public static void main(String[] args) {
        TrapI trapI = new TrapI();
        int trap = trapI.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    // 先找最大值较小的一端，从该端向中间移动，遇到的每个height[i]都会被另一端（因为较大）接住。
    // 因此只需要考虑较小端能达到多少高度，就可以得到接的水的量
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int res = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                res += maxLeft - height[left++];
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                res += maxRight - height[right--];
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return res;
    }
}
