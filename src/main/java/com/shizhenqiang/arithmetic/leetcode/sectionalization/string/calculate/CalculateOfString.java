package com.shizhenqiang.arithmetic.leetcode.sectionalization.string.calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/calculator-lcci/
 */
public class CalculateOfString {

    public static void main(String[] args) {
        CalculateOfString calculateOfString = new CalculateOfString();
        int calculate = calculateOfString.calculate("3+2*2");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        char[] chars = s.trim().toCharArray();
        int i = 0, ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (i < chars.length) {
            if (chars[i] == ' ') {i ++; continue;}
            char tmp = chars[i];
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                i++;
                while (i < chars.length && chars[i] == ' ') i++;
            }
            int num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = deque.pop() * num;
                    break;
                case '/' :
                    num = deque.pop() / num;
                    break;
                default: break;
            }
            deque.push(num);
        }
        while (!deque.isEmpty()) ans += deque.pop();
        return ans;
    }
}
