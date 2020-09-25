package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.sumOddLengthSubarrays;

/**
 *https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOddLengthSubarrays {

    public static void main(String[] args) {
        SumOddLengthSubarrays sumOddLengthSubarrays = new SumOddLengthSubarrays();
        int subarrays = sumOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
        System.out.println(subarrays);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i ++) {
            int lOdd = (i + 1) /2;
            int lEven = i / 2 + 1;
            int rOdd = (arr.length - i ) / 2;
            int rEvent = (arr.length - i + 1)/ 2;
            num += (lOdd * rOdd + lEven * rEvent) * arr[i];
        }
        return num;
    }
}
