package com.shizhenqiang.arithmetic.leetcode.fourweek;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 */
public class GenerateParenthesis {


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(1);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, 0,0,n, "");
        return list;
    }

    private void generate(List<String> list, int left, int right, int len, String s) {
        // termination
        if (left == len && right == len) {
            list.add(s);
            return;
        }
        if (left < len) {
            generate(list, left + 1, right, len, s+"(");
        }
        if (right < left) {
            generate(list, left , right + 1, len, s+")");
        }

    }
}
