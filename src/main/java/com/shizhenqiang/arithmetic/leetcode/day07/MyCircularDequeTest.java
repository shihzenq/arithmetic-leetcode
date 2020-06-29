package com.shizhenqiang.arithmetic.leetcode.day07;

public class MyCircularDequeTest {

    public static void main(String[] args) {

//        MyCircularDeque circularDeque = new MyCircularDeque(3);

//        MyCircularDequeTwo circularDeque = new MyCircularDequeTwo<>(3);
        MyCircularDequeFive circularDeque = new MyCircularDequeFive<>(3);
        System.out.println(circularDeque.insertLast(1));// 返回 true
        System.out.println(circularDeque.insertLast(2));                    // 返回 true
        System.out.println(circularDeque.insertFront(3));                // 返回 true
        System.out.println(circularDeque.insertFront(4));// 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                        // 返回 true
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 返回 true
        System.out.println(circularDeque.getFront());                // 返回 4

    }
}
