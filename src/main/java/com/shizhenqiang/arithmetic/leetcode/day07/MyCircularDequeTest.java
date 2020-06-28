package com.shizhenqiang.arithmetic.leetcode.day07;

public class MyCircularDequeTest {

    public static void main(String[] args) {

        MyCircularDeque circularDeque = new MyCircularDeque(3);
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        boolean b = circularDeque.insertFront(4);// 已经满了，返回 false
        System.out.println(b);
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4

    }
}
