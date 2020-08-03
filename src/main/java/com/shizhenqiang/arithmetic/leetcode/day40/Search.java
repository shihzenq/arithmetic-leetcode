package com.shizhenqiang.arithmetic.leetcode.day40;


/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Search {

    public static void main(String[] args) {
        Search search = new Search();
       int num =  search.search(new int[] {4,5,6,7,0,1,2}, 0);
        System.out.println(num);
    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length -1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // 根据num[mid] 与mid[lo]的关系判断mid是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断target是在mid的左边还是右边，从而调整左右边界lo和hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid-1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target<= nums[hi]) {
                    lo = mid + 1;
                } else hi = mid -1;
            }
        }
        return -1;
    }
}
