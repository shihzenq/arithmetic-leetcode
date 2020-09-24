package com.shizhenqiang.arithmetic.leetcode.sectionalization.array.getWinner;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-an-array-game/
 */
public class GetWinner {

    public static void main(String[] args) {
        GetWinner getWinner = new GetWinner();
        int winner = getWinner.getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7);
        System.out.println(winner);
    }

    public int getWinner(int[] arr, int k) {
        // i：数据索引， j: 连续胜利的次数
        int i = 0, j = 0;
        while (j < k && i < arr.length-1) {
            if (arr[i + 1] < arr[i]) {
                arr[i + 1] = arr[i];
                j++;
            } else j = 1;
            i++;
        }
        return arr[i];
    }
}
