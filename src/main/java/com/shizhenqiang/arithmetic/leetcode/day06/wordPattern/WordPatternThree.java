package com.shizhenqiang.arithmetic.leetcode.day06.wordPattern;

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
public class WordPatternThree {


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
        if (null == pattern || str == null) {
            return false;
        }
        String[] strSplit = str.split(" ");
        if (pattern.length() != strSplit.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < strSplit.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i),i), map.put(strSplit[i], i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean wordPatternOne(String pattern, String str) {
        if (null == pattern || str == null) {
            return false;
        }
        String[] strSplit = str.split(" ");
        if (pattern.length() != strSplit.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
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
