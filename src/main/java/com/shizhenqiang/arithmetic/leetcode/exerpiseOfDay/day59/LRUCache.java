package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day59;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * https://leetcode-cn.com/problems/lru-cache/#/
 */
public class LRUCache {

    class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node() {
            this(0,0);
        }
    }

    private int capacity, count;

    private Map<Integer, Node> map;

    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (Objects.isNull(node))return -1;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (Objects.isNull(node)) {
             node = new Node(key, value);
             map.put(key, node);
             add(node);
             count++;
        } else {
            node.value = value;
            update(node);
        }
        if (count > capacity) {
            Node del = tail.prev;
            map.remove(del.key);
            remove(del);
            count--;
        }
    }

    private void add (Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}