package com.shizhenqiang.arithmetic.leetcode.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/4sum/
 */
public class FourSumThree {

    public static void main(String[] args) {


        List<List<Integer>> lists = fourSum(new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12);
        System.out.println(lists);
    }

    private static List<List<Integer>> fourSum(int[] array, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (array == null || array.length < 4) {
            return lists;
        }
        int length = array.length;
        Arrays.sort(array);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            // 获得最小值，如果大于target，则continue
            int num = array[i] + array[i + 1] + array[i + 2] + array[i + 3];
            if (num > target) {
                continue;
            }
            // 获得最大值，如果小于target, 则continue
            num = array[i] + array[length - 1] + array[length - 2] + array[length - 3];
            if (num < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int z = length - 1;
                // 获得最小值，如果大于target，则continue
                num = array[i] + array[j] + array[k] + array[k + 1];
                if (num > target) {
                    continue;
                }
                // 获得最大值，如果小于target，则continue
                num = array[i] + array[j] + array[z] + array[z - 1];
                if (num < target) {
                    continue;
                }
                while (k < z) {
                    int sum = array[i] + array[j] + array[k] + array[z];
                    if (sum == target) {
                        lists.add(Arrays.asList(array[i], array[j], array[k], array[z]));
                        while (k < z && array[k] == array[k + 1]) k++;
                        while (k < z && array[z] == array[z - 1]) z--;
                        k++;
                        z--;
                    } else if (sum < target) k++;
                      else z--;
                }
            }
        }
        return lists;
    }

}
