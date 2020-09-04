package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum02 {

    public static void main(String[] args) {
        int[] array = {3, 3};
        int target = 6;

        // 使用Map集合存储并进行判断
        int[] a = calculateSumOne(array, target);
        System.out.println(Arrays.toString(a));

        a = calculateSumTwo(array, target);
        System.out.println(Arrays.toString(a));
    }

    private static int[] calculateSumTwo(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int num = target- array[i];
            // 双层遍历，判断i != j 并 num == array[j]
            for (int j = 0; j < array.length; j++) {
                if (i != j && num == array[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static int[] calculateSumOne(int[] array, int target) {
        // key 为 数组值，value为数组索引值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = target - array[i];
            // 遍历数组，target- 遍历的数组值，此值是否存在map中，并且存储的索引不能和此时遍历的数组索引值相等
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{map.get(num), i};
            }
            map.put(array[i], i);
        }
        return null;
    }

}
