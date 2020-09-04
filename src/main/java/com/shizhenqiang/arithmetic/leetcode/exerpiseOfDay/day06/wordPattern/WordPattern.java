package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day06.wordPattern;

import java.util.*;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {


    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        // "abba"
        //"dog dog dog dog"
        boolean a = wordPatternOne(pattern, str);
        System.out.println(a);
        a = wordPatternTwo(pattern, str);
        System.out.println(a);
    }

    private static boolean wordPatternTwo(String pattern, String str) {
        if (null == pattern || null == str) {
            return false;
        }
        String[] strSplit = str.split(" ");
        if (pattern.length() != strSplit.length) {
            return false;
        }

        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < strSplit.length; i++) {
            /**
             * 为什么使用Integer， 是因为int数值不在-128或127的话，用==会返回false，比较的不在整数类型，而是包装类引用。
             * map.put(pattern.charAt(i)，如果重复的添加，则返回value值，通过比较value来判断是abba 是不是 dog cat cat dog
             */
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(strSplit[i], i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean wordPatternOne(String pattern, String str) {
        if (null == pattern || null == str) {
            return false;
        }
        String[] strSplit = str.split(" ");
        if (pattern.length() != strSplit.length) {
            return false;
        }
        /**
         * 1、 创建Map集合，用来根据key做判断
         * 2、遍历strSplit， pattern中单个字符作为key，value为遍历的字符串， 如果包含key，但value字符串不相同则返回false。
         * 3、创建HashSet， 保存value，为了检验是否有重复的value，不使用map.containsValue，降低时间复杂度
         */
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strSplit.length; i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(strSplit[i])) {
                    return false;
                }
            } else {
                if (set.contains(strSplit[i])) {
                    return false;
                }
                map.put(key, strSplit[i]);
                set.add(strSplit[i]);
            }
        }
        return true;
    }
}
