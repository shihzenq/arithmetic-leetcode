package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day05;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(4);
        head1.next = next1;
        next1.next = next2;

        ListNode head2 = new ListNode(1);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        head2.next = next3;
        next3.next = next4;

//        ListNode node = mergeTwoListsOne(head1, head2);
//        System.out.println(node);
        ListNode node = mergeTwoListsTwo(head1, head2);
        System.out.println(node);
    }

    private static ListNode mergeTwoListsTwo(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        while (head1 != null  && head2 != null) {
            if (head1.val < head2.val) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }
        prev.next = null == head1 ? head2 : head1;
        return res.next;
    }

    private static ListNode mergeTwoListsOne(ListNode head1, ListNode head2) {
        if (head1 == null ) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = mergeTwoListsOne(head1.next, head2);
            return head1;
        }

        head2.next = mergeTwoListsOne(head2.next, head1);
        return head2;

    }
}
