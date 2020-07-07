package com.shizhenqiang.arithmetic.leetcode.day14;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树实现 插入、前中后序遍历
 */
public class Traversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root,2);
        insert(root,3);
        insert(root,4);
        insert(root,7);
        insert(root,8);
        insert(root,6);
        List<Integer> list = preOrderTraversal(root);
        System.out.println("前序遍历：" + list);
        list = inOrderTraversal(root);
        System.out.println("中序遍历：" + list);
        list = postOrderTraversal(root);
        System.out.println("后序遍历：" + list);
    }

    /**
     * 后序遍历
     * 左右根
     * @param root
     * @return
     */
    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack  = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return list;
    }

    /**
     * 中序遍历
     * 左根右
     * @param root
     * @return
     */
    private static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 前序遍历，
     * 根左右
     * @param root
     * @return
     */
    private static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }

    private static void insert(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left != null) {
                insert(root.left, value);
            } else root.left = new TreeNode(value);
        } else if (value > root.val) {
            if (root.right != null) {
                insert(root.right, value);
            } else root.right = new TreeNode(value);
        }
    }


}
