package com.shizhenqiang.arithmetic.leetcode.fourweek.findLadders;


import java.util.*;

/**
 * 题目描述
 * 评论 (304)
 * 题解(165)
 * 提交记录
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
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
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 */
public class FindLaddersTwo {

    public static void main(String[] args) {
        FindLaddersTwo findLadders = new FindLaddersTwo();
        List<List<String>> lists = findLadders.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        System.out.println(lists);
    }

    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return lists;
        }
        // 单词表放入set集合中，因为contains() 时间复杂度为O(1)
        Set<String> setWord = new HashSet<>(wordList);
        Deque<List<String>> deque = new LinkedList<>();
        List<String> path = new ArrayList<>();
        // 是否包含过
        Set<String> visited = new HashSet<>();
        // 是否达到最低端
        boolean isFund = false;
        path.add(beginWord);
        visited.add(beginWord);
        deque.offer(path);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> poll = deque.poll();
                if (poll != null && poll.size() != 0) {
                    String temp = poll.get(poll.size() - 1);
                    List<String> matchingList = getMatching(temp, setWord);
                    for (String matching : matchingList) {
                        if (!visited.contains(matching)) {
                            if (matching.equals(endWord)) {
                                isFund = true;
                                poll.add(matching);
                                lists.add(new ArrayList<>(poll));
                                poll.remove(poll.size() - 1);
                            }
                            poll.add(matching);
                            deque.add(new ArrayList<>(poll));
                            poll.remove(poll.size() - 1);
                            subVisited.add(matching);
                        }
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFund) {
                break;
            }
        }
        return lists;
    }

    private List<String> getMatching(String s, Set<String> setWord) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String newString = new String(chars);
                if (setWord.contains(newString)) {
                    res.add(newString);
                }
            }
            chars[i] = old;
        }
        return res;
    }


}
