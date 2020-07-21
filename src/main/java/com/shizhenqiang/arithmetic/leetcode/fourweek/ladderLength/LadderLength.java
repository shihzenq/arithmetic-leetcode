package com.shizhenqiang.arithmetic.leetcode.fourweek.ladderLength;


import java.util.*;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class LadderLength {

    public static void main(String[] args) {

        LadderLength ladderLength = new LadderLength();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int length = ladderLength.ladderLength("hit", "cog", wordList);
        System.out.println(length);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        // 使用队列来保存
        Deque<String> stack = new LinkedList<>();
        stack.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int depth = 2;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                String begin = stack.poll();
                char[] chars = begin.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) {
                            continue;
                        }
                        chars[j] = c;
                        String newString = String.valueOf(chars);
//                        if (wordSet.contains(newString)) {
//                            if (endWord.equals(newString)) {
//                                return depth;
//                            } else if (!visited.contains(newString)) {
//                                visited.add(newString);
//                                stack.add(newString);
//                            }
//                        }
                        if (endWord.equals(newString)) {
                            return depth;
                        } else if (wordSet.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            stack.add(newString);
                        }

                    }
                    chars[j] = old;
                }
            }
            depth++;
        }
        return 0;
    }
}
