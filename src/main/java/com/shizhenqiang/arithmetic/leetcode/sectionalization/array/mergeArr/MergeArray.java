package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.mergeArr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeArray {

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        mergeArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        mergeArray.mergeII(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public void mergeII(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n -1;
        int p = m + n -1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        System.out.println(Arrays.toString(nums1));
    }
}
