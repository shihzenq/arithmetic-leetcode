package com.shizhenqiang.arithmetic.leetcode.day07.singleList;

/**
 * 实现单链表
 */
public class SingleLinkedListTwo<T> {

    private int size;

    private Node<T> head;

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
    }

    public void addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> h = head;
            while (h.next != null) {
                h = h.next;
            }
            h.next = newNode;
        }
        size++;
    }

    public void add(T data, int i) {
        if (size == 0) {
            addHead(data);
        } else if (i >= size) {
            addLast(data);
        }
        Node<T> node = findNodeByIndex(i - 1);
        Node<T> newNode = new Node<>(data);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    private Node<T> findNodeByIndex(int i) {
        int index = 0;
        Node<T> h = head;
        while (h != null) {
            if (index == i) {
                return h;
            }
            h = h.next;
            index++;
        }
        return null;
    }

    public void deleteHead() {
        if (null == head) {
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (null == head) {
            return;
        }
        Node<T> h = head;
        Node<T> prev = h;
        int index = 0;
        while (h != null) {
            if (index == size) {
                prev.next = null;

                break;
            }
            h = h.next;
            prev = h;
        }
        size--;
    }

    public void delete(int i) {
        if (head == null) {
            return;
        }
        if (i == 0) {
            deleteHead();
        } else if (i >= size) {
            deleteLast();
        } else {
            Node<T> h = head;
            int index = 0;
            Node<T> prev = h;
            while (h != null) {
                if (index == i) {
                    prev.next = h.next;
                    h.next = null;
                    break;
                }
                prev = h;
                h = h.next;
                index++;
            }
        }
        size--;
    }

}
