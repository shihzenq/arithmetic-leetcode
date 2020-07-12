package com.shizhenqiang.arithmetic.leetcode.thirdWeek;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    static List<String> list;

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }

    private static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generate(0, 0, n, "");
        return list;
    }

    private static void generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        // process

        // dill down
        if (left < n) {
            generate(left + 1, right, n, s+"(");
        }
        if (right < left) {
            generate(left, right + 1, n, s+")");
        }

        // reverse

    }
}
