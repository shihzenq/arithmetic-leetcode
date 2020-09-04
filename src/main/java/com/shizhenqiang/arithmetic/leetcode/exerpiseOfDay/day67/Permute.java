package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day67;

import java.util.*;

/**
 *46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(new int[]{1, 2, 3});
        System.out.println(lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)  return lists;
        Set<Integer> used = new HashSet<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(lists, used, path,nums, 0 , nums.length);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, Set<Integer> used, Deque<Integer> path, int[] nums, int depth, int length) {
        if (depth == length) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <length; i ++) {
            if (!used.contains(i)) {
                used.add(i);
                path.add(nums[i]);
                dfs(lists, used, path, nums, depth+1, length);
                used.remove(i);
                path.removeLast();
            }
        }

    }
}
