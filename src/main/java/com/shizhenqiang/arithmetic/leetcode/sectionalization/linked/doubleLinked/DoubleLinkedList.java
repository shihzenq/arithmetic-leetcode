package com.shizhenqiang.arithmetic.leetcode.sectionalization.linked.doubleLinked;

import com.shizhenqiang.arithmetic.leetcode.sectionalization.linked.ILinkedList;

/**
 * 双向链表实现
 * https://blog.csdn.net/javazejian/article/details/53047590
 *
 * @param <T>
 */
public class DoubleLinkedList<T> implements ILinkedList<T> {

    private DNode<T> head; // 虚节点

    private DNode<T> tail; // 尾节点

    public DoubleLinkedList() {
        this.head = this.tail = new DNode<>();
    }


    /**
     * 传入数组转成链表
     *
     * @param array
     */
    public DoubleLinkedList(T[] array) {
        this();
        if (array == null || array.length == 0) return;
        this.head.next = new DNode<>(array[0]);
        this.tail = this.head.next;
        this.tail.prev = head;
        int j = 1;
        while (j < array.length) {
            tail.next = new DNode<>(array[j++]);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }


    public int length() {
        int length = 0;
        DNode d = head;
        while (d.next != null) {
            length++;
            d = d.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index < 0) return null;
        DNode<T> h = head;
        int i = 0;
        while (h.next != null && i < index) {
            h = h.next;
            i++;
        }
        if (h != null) {
            return h.data;
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (index < 0 || data == null) return null;
        DNode<T> h = head;
        int i = 0;
        T old = null;
        while (h.next != null && i < index) {
            h = h.next;
            i++;
        }
        if (h != null) {
            old = h.data;
            h.data = data;
        }
        return old;
    }

    @Override
    public boolean add(int index, T data) {
        if (index < 0 || data == null) return false;
        int i = 0;
        DNode<T> h = head;
        while (h.next != null && i < index) {
            h = h.next;
            i++;
        }
        DNode<T> d = new DNode<>(data, h, h.next);
        if (h.next != null) {
            h.next.prev = d;
        }
        h.next = d;
        if (h == tail) {
            tail = d;
        }
        return true;
    }

    @Override
    public boolean add(T data) {
        if (data == null) return false;
        DNode<T> d = new DNode<>(data, tail, null);
        tail.next = d;
        tail = d;
        return true;
    }

    @Override
    public T remove(int index) {
        int length = length();
        if (index <= 0 || index >= length || isEmpty()) return null;
        T data = null;
        int i = 0;
        DNode<T> d = head;
        while (d.next != null && i <= index) {
            d = d.next;
            i++;
        }
        if (d.next != null) {
            d.next.prev = d.prev;
        }
        d.prev.next = d.next;
        if (d ==tail) {
            tail = d;
        }
        data = d.data;
        return data;
    }

    @Override
    public boolean remove(T data) {
        if (data == null) return false;
        DNode<T> d = head.next;
        boolean isRemove = false;
        while (d != null) {
            if (d.data.equals(data)) {
                if (d == tail) {
                    tail = d.prev;
                    d.prev = null;
                    tail.next = null;
                } else {
                    d.prev.next = d.next;
                    d.next.prev = d.prev;
                }
                isRemove = true;
                d = d.next;
            } else {
                d = d.next;
            }
        }
        return isRemove;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
    }

    @Override
    public boolean contains(T data) {
        if (data == null) return false;
        DNode<T> d = head.next;
        while (d != null) {
            if (d.data.equals(data)) {
                return true;
            } else d = d.next;
        }
        return false;
    }

    @Override
    public String toString() {
        String str="(";
        DNode<T> pre = this.head.next;
        while (pre!=null)
        {
            str += pre.data;
            pre = pre.next;
            if (pre!=null)
                str += ", ";
        }
        return str+")";
    }


    public static void main(String[] args) {
        DoubleLinkedList<String> headDoubleILinkedList = new DoubleLinkedList();
        System.out.println(headDoubleILinkedList);

        String[] letters={"A","B","C","D","Z","E","F"};
//        String[] letters={"A"};
        DoubleLinkedList<String> list=new DoubleLinkedList<>(letters);

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(0,"Y"));
        System.out.println("list:"+list.toString());
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());


        System.out.println("list.remove(6)-->"+list.remove(6));
//        System.out.println("list.remove(Z)->"+list.removeAll("Z"));
        System.out.println("list:"+list.toString());
    }

}
