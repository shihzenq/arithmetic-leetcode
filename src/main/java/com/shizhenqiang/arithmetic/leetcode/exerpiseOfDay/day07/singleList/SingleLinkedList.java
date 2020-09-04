package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day07.singleList;

/**
 * 实现单链表
 */
public class SingleLinkedList<T> {

    private Node<T> head;

    private int size;

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }

    public void addHead(T data) {

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> h = head;
        Node<T> newNode = new Node<>(data);
        if (h == null) {
            head = newNode;
        } else {
            while (h.next != null) {
                h = h.next;
            }
            h.next = newNode;
        }
        size++;
    }

    public void add(T data, int i) {
        if (i == 0) {
            addHead(data);
        } else if (i >= size) {
            addLast(data);
        } else {
            Node<T> node = findNodeByIndex(i-1);
            Node<T> newNode = new Node<>(data);
            newNode.next = node.next;
            node.next = newNode;
//            int headIndex = 0;
//            Node<T> h = head; // 当前节点
//            Node<T> prev = h; // 前置节点
//            while (h != null) {
//                if (headIndex == i) {
//                    newNode.next = h;
//                    prev.next = newNode;
//                    return;
//                }
//                prev = h;
//                h = h.next;
//                headIndex++;
//            }
        }
        size++;
    }

    private Node<T> findNodeByIndex(int i) {
        int index = 0;
        Node<T> node = head;
        while (node != null) {
            if (index == i) {
                return node;
            }
            node = node.next;
            index++;
        }
        return null;
    }

    public void deleteHead() {
        Node<T> h = head;
        if (h == null) {
            return;
        }
        head = h.next;
        size--;
    }

    public void deleteLast() {
        Node<T> h = head;
        if (h == null) {
            return;
        }
        int index = 0;
        while (h.next != null) {
            if (index == size) {
                h.next = null;
            }
            h = h.next;
        }
        size--;
    }

    public void delete(int i) {
        if (i == 0) {
            deleteHead();
        } else if (i == size) {
            deleteLast();
        } else {
            int index = 0;
            Node<T> cur = head;
            Node<T> prev = cur;
            while (cur != null) {
                if (i == index) {
                    prev.next = cur.next;
                    cur.next = null;
                    break;
                }
                prev = cur;
                cur = cur.next;
                index++;
            }
        }
        size--;
    }

}
