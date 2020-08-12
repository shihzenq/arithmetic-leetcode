package com.shizhenqiang.arithmetic.leetcode.linked.doubleLinked;

public class DNode<T> {
    public T data;

    public DNode<T> prev, next;

    public DNode(T data, DNode<T> prev, DNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DNode(T data) {
        this(data, null, null);
    }

    public DNode() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        return "DNode{" +
                "data=" + data +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
