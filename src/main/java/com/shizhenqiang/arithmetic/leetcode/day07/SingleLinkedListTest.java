package com.shizhenqiang.arithmetic.leetcode.day07;

/**
 * 实现单链表
 */
public class SingleLinkedListTest{


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead(1);
        linkedList.addHead(4);
        linkedList.addLast(2);
        linkedList.add(3, 1);
        linkedList.delete(1);
        System.out.println(linkedList);
    }

    
}
