package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day07;

/**
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque<E> {

    /**
     * the capacity bound, 1 or 1000 if none
     */
    private final int k;


    transient int size = 0;

    /**
     * Linked list node class.
     */
    static final class Node<E> {
        /**
         * The item, or null if this node has been removed.
         */
        Integer item;

        /**
         * One of:
         * - the real predecessor Node
         * - this Node, meaning the predecessor is tail
         * - null, meaning there is no predecessor
         */
        Node<E> prev;

        /**
         * One of:
         * - the real successor Node
         * - this Node, meaning the successor is head
         * - null, meaning there is no successor
         */
        Node<E> next;

        Node(Node<E> prev, Integer element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
//        Node<E> newNode = new Node<>(null, k, null);
//        first = newNode;
//        last = newNode;
//        size ++;
        this.k = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(null, value, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        final Node<E> f = first;
        if (f == null) {
            return false;
        }
        // assert f == first && f != null;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        final Node<E> l = last;
        if (l == null) {
            return false;
        }
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        final Node<E> f = first;
        if (f == null) {
            return  -1;
        }
        return f.item;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        final Node<E> l = last;
        if (null == l) {
            return -1;
        }
        return l.item;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return k == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
