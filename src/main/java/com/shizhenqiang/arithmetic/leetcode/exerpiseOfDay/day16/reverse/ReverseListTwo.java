package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day16.reverse;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseListTwo {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        insert(root, 2);
        insert(root, 3);
        insert(root, 4);
        insert(root, 5);
        ListNode reverse = null;
//         reverse =  reverseList(root);
//        System.out.println(reverse);
        reverse =  reverseListTwo(root);
        System.out.println(reverse);
    }

    private static ListNode reverseListTwo(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode node = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }

    private static ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return null;
        }
        ListNode r = root;
        ListNode prev = null;
        while (r != null) {
            ListNode node = r.next;
            r.next = prev;
            prev = r;
            r = node;
        }
        return prev;
    }

    private static void insert(ListNode root, int value) {
        if (root.next != null) {
            insert(root.next, value);
        } else root.next = new ListNode(value);
    }
}
