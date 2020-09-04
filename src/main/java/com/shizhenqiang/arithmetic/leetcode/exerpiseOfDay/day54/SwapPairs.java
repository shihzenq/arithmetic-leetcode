package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day54;


/**
 *24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = swapPairs.swapPairs(head);
        System.out.println(listNode);
    }


    /**
     *  1->2->3->4->5
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode preNode = res;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            preNode.next = second;
            first.next = second.next;
            second.next = first;
            preNode = first;
            head = first.next;
        }
        return res.next;
    }
}
