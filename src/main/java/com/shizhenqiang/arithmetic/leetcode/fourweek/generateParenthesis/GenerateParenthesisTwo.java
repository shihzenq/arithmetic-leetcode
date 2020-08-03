package com.shizhenqiang.arithmetic.leetcode.fourweek.generateParenthesis;


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
public class GenerateParenthesisTwo {


    public static void main(String[] args) {
        GenerateParenthesisTwo generateParenthesis = new GenerateParenthesisTwo();
        List<String> list = generateParenthesis.generateParenthesis(1);
        System.out.println(list);
    }

    private List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, 0, 0, n, "");
        return list;
    }

    private void generate(List<String> list, int left, int right, int n, String s) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

    }

}
