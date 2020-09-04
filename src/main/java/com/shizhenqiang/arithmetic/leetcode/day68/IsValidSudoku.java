package com.shizhenqiang.arithmetic.leetcode.day68;

import java.util.HashMap;
import java.util.Map;

/**
 *36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *https://leetcode-cn.com/problems/valid-sudoku/description/
 */
public class IsValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer> [] rows = new HashMap[9];
        Map<Integer, Integer> [] columns = new HashMap[9];
        Map<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0 ; i < 9 ; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i =0 ; i< 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int boxIndex = (i/3) * 3 + j /3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0 ) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
