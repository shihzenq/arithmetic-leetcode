package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day07.singleList;

/**
 * 实现单链表
 */
public class SingleLinkedListFour<T> {

    private Node<T> head;

    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

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
        if (null == head) {
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
        if (i == 0) {
            addHead(data);
        } else if (i >= size) {
            addLast(data);
        } else {
            Node<T> node = findNodeByIndex(i - 1);
            Node<T> newNode = new Node<>(data);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    private Node<T> findNodeByIndex(int i) {
        Node<T> h = head;
        int index = 0;
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
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public void deleteLast() {
        if (head != null) {
            Node<T> h = head;
            Node<T> prev = h;
            int index = 1;
            while (h != null) {
                if (index == size) {
                   prev.next = null;
                   break;
                }
                prev = h;
                h = h.next;
                index++;
            }
            size--;
        }
    }

    public void delete(int i) {
        if (i == 0) {
            deleteHead();
        } else if (i >= size) {
            deleteLast();
        } else {
            Node<T> h = head;
            Node<T> prev = h;
            int index = 0;
            while (h.next != null) {
                if (index == i) {
                    prev.next = h.next;
                    h.next = null;
                    break;
                }
                prev = h;
                h = h.next;
                index++;
            }
            size--;
        }
    }


}
