package com.shizhenqiang.arithmetic.arithmetic.day04;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
        System.out.println(head);
//        ListNode node = swapTwoAdjacentNodesOfOne(head);
//        System.out.println(node);

//        ListNode node = swapTwoAdjacentNodesOfTwo(head);
//        System.out.println(node);
        ListNode node = swapTwoAdjacentNodesOfThree(head);
        System.out.println(node);
    }

    private static ListNode swapTwoAdjacentNodesOfTwo(ListNode head) {
        // head 1->2->3->4->5
        // res: -1->1->2->3->4->5
        // 先创建一个链表，这个链表是最后返回的next， -1->1->2->3->4->5
        ListNode res = new ListNode(-1);
        // 1->2->3->4->5
        // res.next指向head
        res.next = head;
        // 临时变量，-1->1->2->3->4->5
        ListNode prevNode = res;
        /**
         * 将1->2->3->4->5 进行两两替换值和位置
         * 第一遍遍历是将2和1值和位置替换，各个变量都是引用替换，故每个引用的值变化，也会引起其他变量所引用的引用而变化
         *      firstNode：1->2->3->4->5
         *      secondNode：2->3->4->5
         *      让临时变量prevNode.next 指向secondNode， 由1->2->3->4->5变为2->3->4->5
         *      然后将firstNode.next = secondNode.next由2->3->4->5变为3->4->5
         *      secondNode.next = firstNode，由3->4->5变为 1->3->4->5， secondNode：2->1->3->4->5
         *      prevNode.next = secondNode， 1->2->3->4->5变为2->1->3->4->5， 此时实现了2和1交换
         *      故res由-1->1->2->3->4->5变为-1->2->1->3->4->5, 因为prevNode和res是同一个引用
         * 第二遍遍历 将 3和4交换
         *      head是3->4->5
         *      firstNode：3->4->5
         *      secondNode：4->5
         *      让临时变量prevNode.next 指向secondNode， 由1->3->4->5变为1->4->5
         *      然后将firstNode.next = secondNode.next由4->5变为5, firstNode: 3->5
         *      secondNode.next = firstNode，由5变为 3->5， secondNode：4->5变为4->3->5
         *      prevNode.next = secondNode， 4->5变为4->3->5， 此时实现了4和3交换
         *      故res由-1->1->2->3->4->5变为-1->2->1->4->3->5, 因为prevNode和res是同一个引用
         */
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode = firstNode;
            head = firstNode.next;
            System.out.println();
        }
        return res.next;
    }

    private static ListNode swapTwoAdjacentNodesOfOne(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // 交换
        firstNode.next = swapTwoAdjacentNodesOfOne(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    private static ListNode swapTwoAdjacentNodesOfThree(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        while (head != null && head.next != null) {
            ListNode start = head;
            ListNode end = head.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
            head = start.next;
        }
        return res.next;
    }

}
