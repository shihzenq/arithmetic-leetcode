package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.mostWater;

public class MaxAreaIII {
    public static void main(String[] args) {
        MaxAreaIII maxAreaIII = new MaxAreaIII();
        int maxArea = maxAreaIII.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length -1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r- l);
            maxArea = Math.max(area, maxArea);
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
