package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day07.singleList;

/**
 * 实现单链表
 */
public class SingleLinkedListTest{


    public static void main(String[] args) {
//        SingleLinkedList linkedList = new SingleLinkedList();
//        SingleLinkedListTwo linkedList = new SingleLinkedListTwo();
//        SingleLinkedListThree linkedList = new SingleLinkedListThree();
        SingleLinkedListFour linkedList = new SingleLinkedListFour();
        linkedList.addHead(1);
        linkedList.addHead(4);
        linkedList.addLast(2);
        linkedList.add(3, 1);
        linkedList.delete(1);
        linkedList.deleteLast();
        linkedList.deleteHead();
        System.out.println(linkedList);
    }

    
}
