package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.maximumProduct;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProduct {

    public static void main(String[] args) {
        MaximumProduct maximumProduct = new MaximumProduct();
        int product = maximumProduct.maximumProduct(new int[]{6,9,6,3,8,4});
        System.out.println(product);
         product = maximumProduct.maximumProductII(new int[]{6,9,6,3,8,4});
        System.out.println(product);
    }

    public int maximumProduct(int[] nums) {
        int maxProduct = 0;
        Arrays.sort(nums);
        int last = nums[nums.length-1];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length -1;
            while (j < k) {
                int target = nums[i] * nums[j] * nums[k];
                if (last >= 0) {
                    maxProduct = Math.max(target, maxProduct);
                } else maxProduct = Math.min(target, maxProduct);
                j++;
                k--;
            }
        }
        return maxProduct;
    }

    public int maximumProductII(int [] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[len-1] < 0) return nums[len-1] * nums[len-2]* nums[len-3];
        if (nums[len-1] == 0) return 0;
        return Math.max(nums[0] * nums[1] * nums[len-1], nums[len-1] * nums[len-2] * nums[len-3]);
    }
}
