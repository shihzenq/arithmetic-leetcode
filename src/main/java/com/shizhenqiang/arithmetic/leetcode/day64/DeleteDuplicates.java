package com.shizhenqiang.arithmetic.leetcode.day64;


/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        add(listNode, 1);
        add(listNode, 2);
        add(listNode, 3);
        add(listNode, 3);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode1 = deleteDuplicates.deleteDuplicates(listNode);
        System.out.println(listNode1);
    }

    public static void  add (ListNode head, int num) {
        if (head.next != null) {
            add(head.next, num);
        } else head.next = new ListNode(num);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
