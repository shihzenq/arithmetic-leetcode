package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day29;


import java.util.*;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * https://leetcode-cn.com/problems/permutations/
 */
public class PermuteTwo {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermuteTwo solution = new PermuteTwo();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    private List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>(functional(len));
        // 创建set集合，判断索引位置没有使用
        Set<Integer> used = new HashSet<>();
        // 创建队列，将数添加到队列中
        Deque<Integer> path = new LinkedList<>();
        dfs(lists, used, path, nums, 0, len);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, Set<Integer> used, Deque<Integer> path, int[] nums, int depth, int len) {
        // 递归出口，// terminator
        if (depth == len) {
            lists.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (!used.contains(i)) {
                used.add(i);
                path.add(nums[i]);
                // 做深度优先搜索
                dfs(lists, used, path, nums, depth+1, len);
                used.remove(i);
                path.removeLast();
            }
        }
    }

    /**
     * 初始化，计算出全排列数组大小
     *
     * @param len
     * @return
     */
    private int functional(int len) {
        int res = 1;
        for (int i = 2; i <= len; i++) {
            res *= i;
        }
        return res;
    }
}
