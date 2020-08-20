package com.shizhenqiang.arithmetic.leetcode.day60;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

/**
 * 460. LFU缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * <p>
 * <p>
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内执行两项操作？
 * <p>
 * https://leetcode-cn.com/problems/lfu-cache/
 */
public class LFUCacheOfLinkedHashSet {

    class Node {
        int key, value;
        int freq = 1;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }



    private Map<Integer, Node> cache;

    // key作为频次
    private Map<Integer, LinkedHashSet<Node>> freqMap;

    private int capacity;

    private int size;

    private int min;


    public LFUCacheOfLinkedHashSet(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (Objects.isNull(node)) return -1;
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cache.get(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node removeNode = removeNode();
                cache.remove(removeNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (Objects.isNull(set)) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node next = set.iterator().next();
        set.remove(next);
        return next;

    }

    private void freqInc(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (Objects.isNull(newSet)) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    public static void main(String[] args) {
        // 使用LinkedHashSet 作为双向链表
        //
        LFUCacheOfLinkedHashSet cache = new LFUCacheOfLinkedHashSet(2 /* capacity (缓存容量) */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4

    }
}
