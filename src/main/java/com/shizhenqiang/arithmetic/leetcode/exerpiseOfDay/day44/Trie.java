package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day44;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

    class Node {
        Node[] v;
        boolean end;

        public Node() {
            v = new Node[26];
            end = false;
        }
    }

    Node root;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.v[ch - 'a'] == null) {
                node.v[ch - 'a'] = new Node();
            }
            node = node.v[ch - 'a'];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.v[ch - 'a'] == null) {
                return false;
            }
            node = node.v[ch - 'a'];
        }
        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.v[ch - 'a'] == null) {
                return false;
            }
            node = node.v[ch - 'a'];
        }
        return true;
    }
}