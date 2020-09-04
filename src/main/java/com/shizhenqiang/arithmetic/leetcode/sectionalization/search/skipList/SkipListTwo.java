package com.shizhenqiang.arithmetic.leetcode.sectionalization.search.skipList;


public class SkipListTwo {

    public static void main(String[] args) {
        SkipListTwo skiplist = new SkipListTwo();

        skiplist.add(0);
        skiplist.add(5);
        skiplist.add(2);
        skiplist.add(1);
        System.out.println(skiplist.search(0));   // 返回 false
        skiplist.erase(5);    // 返回 false，0 不在跳表中
        System.out.println(skiplist.search(2));
        // 返回 true
        skiplist.search(3);    // 返回 true
        skiplist.search(2);   // 返回 false，1 已被擦除
    }

    private static final float SKIP_LIST_P = 0.5f;

    // 高度
    private static final int MAX_LEVEL = 16;

    Node head;

    class Node {
        int val;
        // 后退指针
        Node bw;
        // 前进指针
        Node[] fw;

        public Node(int val) {
            this.val = val;
            fw = new Node[randomLevel()];
        }

        public Node(int val, int size) {
            this.val = val;
            fw = new Node[size + 1];
        }

        private int randomLevel() {
            int level = 1;
            while (Math.random() < SKIP_LIST_P && level < MAX_LEVEL) level++;
            return level;
        }
    }

    public SkipListTwo() {
        head = new Node(-1, MAX_LEVEL);
    }

    public boolean search(int num) {
        Node p = searchNode(num);
        return p.val == num;
    }

    public void add(int num) {
        Node p = searchNode(num);
        Node n = new Node(num);
        n.bw = p;
        for (int i = 0; i < n.fw.length; i++) {
            Node f = p;
            while (f.bw != null && f.fw.length < i + 1) {
                f = f.bw;
            }
            if (i == 0 && f.fw[i] != null) {
                f.fw[i].bw = n;
            }
            n.fw[i] = f.fw[i];
            f.fw[i] = n;
        }
    }

    public boolean erase(int num) {
        if (isEmpty()) return false;
        Node p = searchNode(num);
        if (p.val != num) return false;
        for (int i = 0; i < p.fw.length; i++) {
            Node f = p.bw;
            while (f.bw != null && f.fw.length < i + 1) {
                f = f.bw;
            }
            if (i == 0 && f.fw[i].fw[i] != null) {
                f.fw[i].fw[i].bw = f;
            }
            f.fw[i] = f.fw[i].fw[i];
        }
        return true;
    }

    private Node searchNode(int target) {
        if (isEmpty()) return head;
        Node node = head;
        for (int i = MAX_LEVEL; i >= 0; i--) {
            while (node.fw[i] != null && node.fw[i].val <= target) {
                node = node.fw[i];
            }
        }
        return node;
    }

    private boolean isEmpty() {
        return head.fw[0] == null;
    }
}
