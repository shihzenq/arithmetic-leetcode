package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day57;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqCharThree {

    public static void main(String[] args) {
        FirstUniqCharThree firstUniqChar = new FirstUniqCharThree();
        int uniqChar = firstUniqChar.firstUniqCharOne("leetcode");
        System.out.println(uniqChar);
        uniqChar = firstUniqChar.firstUniqCharTwo("leetcode");
        System.out.println(uniqChar);
    }

    private int firstUniqCharTwo(String str) {
        if (str.length() == 0) return -1;
        char[] chars = str.toCharArray();
        int[] arr = new int[26];
        for (char c : chars) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    private int firstUniqCharOne(String str) {
        if (str.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return -1;
    }


}
