package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day36;


/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSumThree {

    public static void main(String[] args) {

        MinPathSumThree minPathSum = new MinPathSumThree();
        int i = minPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }

    private int minPathSum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) arr[i][j] = arr[i][j - 1] + arr[i][j];
                else if (j == 0) arr[i][j] = arr[i - 1][j] + arr[i][j];
                else {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + arr[i][j];
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }


    /**
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
}
