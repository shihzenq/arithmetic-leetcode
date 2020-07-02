package com.shizhenqiang.arithmetic.leetcode.day10;


import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List<String> list = fizzBuzzOne(15);
        System.out.println(list);
        list = fizzBuzzTwo(15);
        System.out.println(list);
    }

    private static List<String> fizzBuzzTwo(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3  && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else {
                if (fizz == 3) {
                    list.add("Fizz");
                    fizz = 0;
                } else if (buzz == 5) {
                    list.add("Buzz");
                    buzz = 0;
                } else {
                    list.add(String.valueOf(i));
                }
            }
        }
        return list;
    }

    private static List<String> fizzBuzzOne(int i) {
        if (i < 1) return null;
        List<String> list = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            if (j % 3 == 0 && j % 5 == 0) {
                list.add("FizzBuzz");
            } else {
                if (j % 3 == 0) {
                    list.add("Fizz");
                } else if (j % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(j + "");
                }
            }
        }
        return list;
    }
}
