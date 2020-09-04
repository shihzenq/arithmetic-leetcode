package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day27;

import java.util.*;

/**
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意:
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * 返回值: 1
 * 示例 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * 返回值: 2
 * 示例 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * 返回值: 3
 * <p>
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
 */
public class MinMutation {
    public static void main(String[] args) {
        // "AACCTTGG"
        //"AATTCCGG"
        //["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
        int a = minMutationBFS("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"});
//        int a = minMutationDFS("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
        System.out.println(a);
    }

    private static int minMutationDFS(String start, String end, String[] bank) {

        return 0;
    }

    /**
     * 通过BFS广度优先搜索解析
     * 思路:
     * 出队，当前队列中所有的元素
     * 如果当前的字符串变化正好是目标值就返回count的值
     * 如果不是就将当前的一个字符进行替换，查看是否在基因库，是否先前访问过
     * 判断1：当前的字符串是否被访问过，被访问过说明陷入了循环，不可能变成目标值。
     * 判断2：当前的字符串是否在基因库，如果在，就记录这个新的字符串被访问过，并且把这个新字符串加入到队列中
     * 把当前层所有的可能性放入到队列中，当前层全记录完后当前的count++
     * 进入到下一层，同样的逻辑
     * @param end
     * @param bank
     * @return
     */
    public static int minMutationBFS(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }
}
