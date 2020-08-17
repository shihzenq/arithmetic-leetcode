package com.shizhenqiang.arithmetic.leetcode.day57;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        int uniqChar = firstUniqChar.firstUniqCharTwo("loveleetcode");
//        int uniqChar = firstUniqChar.firstUniqCharTwo("leetcode");
        System.out.println(uniqChar);
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0 ; i < chars.length; i ++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharTwo(String s) {
        if (s.length() == 0) return -1;
        int [] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c - 'a'] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
