package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day39;

import java.util.*;

/**
 *589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class NPreOrder {

    public static void main(String[] args) {
        Node node = new Node(1);
        List<Node> children = new ArrayList<>();
        Node node3 = new Node(3);
        children.add(node3);
        Node node32 = new Node(5);
        Node node34 = new Node(6);
        node3.children = Arrays.asList(node32,node34);
        children.add(new Node(2));
        children.add(new Node(4));
        node.children = children;
        NPreOrder nPreOrder = new NPreOrder();
//        List<Integer> list = nPreOrder.preOrder(node);
        List<Integer> list = nPreOrder.preOrderTwo(node);
        System.out.println(list);
    }

    public List<Integer> preOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            Collections.reverse(node.children);
            if (node.children!= null && !node.children.isEmpty()) {
                for (Node n : node.children) {
                    stack.add(n);
                }
            }
        }

        return list;
    }

    public List<Integer> preOrderTwo(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
           root = stack.pollLast();
            list.add(root.val);
            if (root.children!= null && !root.children.isEmpty()) {
                for (int i = root.children.size() -1; i >=0 ; i--) {
                    stack.add(root.children.get(i));
                }
            }
        }
        return list;
    }
}
