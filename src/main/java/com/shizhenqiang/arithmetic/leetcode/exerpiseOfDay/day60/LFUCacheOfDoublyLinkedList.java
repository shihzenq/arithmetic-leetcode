package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day60;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LFUCacheOfDoublyLinkedList {

    private Map<Integer, Node> cache;

    private Map<Integer, DoublyLinkedList> freqMap;

    private int size;

    private int capacity;

    private int min;

    public LFUCacheOfDoublyLinkedList(int capacity) {
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
                DoublyLinkedList doublyLinkedList = freqMap.get(min);
                cache.remove(doublyLinkedList.tail.prev.key);
                doublyLinkedList.removeNode(doublyLinkedList.tail.prev);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoublyLinkedList doublyLinkedList = freqMap.get(1);
            if (Objects.isNull(doublyLinkedList)) {
                doublyLinkedList = new DoublyLinkedList();
                freqMap.put(1, doublyLinkedList);
            }
            doublyLinkedList.addNode(newNode);
            size++;
            min = 1;
        }
    }

    private void freqInc(Node node) {
        int freq = node.freq;
        DoublyLinkedList doublyLinkedList = freqMap.get(freq);
        doublyLinkedList.removeNode(node);
        if (freq == min && doublyLinkedList.head.next.equals(doublyLinkedList.tail)) {
            min = freq + 1;
        }
        DoublyLinkedList list = freqMap.get(freq + 1);
        if (Objects.isNull(list)) {
            list = new DoublyLinkedList();
            freqMap.put(freq + 1, list);
        }
        node.freq++;
        list.addNode(node);
    }

    public static void main(String[] args) {
        LFUCacheOfDoublyLinkedList cache = new LFUCacheOfDoublyLinkedList(2 /* capacity (缓存容量) */);

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

class DoublyLinkedList {

    Node head; // 虚节点
    Node tail;


    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    Node prev;

    Node next;

    int key, value;

    int freq = 1;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
