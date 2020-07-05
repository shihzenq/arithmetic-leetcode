package com.shizhenqiang.arithmetic.leetcode.day13;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root,2);
        insert(root,3);
        insert(root,4);
        insert(root,7);
        insert(root,8);
        insert(root,6);

        List<Integer> list = preOrderTraversal(root);
        System.out.println(list);

        list = preOrderTraversalTwo(root);
        System.out.println(list);

        list = preOrderTraversalThree(root);
        System.out.println(list);
    }

    private static List<Integer> preOrderTraversalThree(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    private static List<Integer> preOrderTraversalTwo(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> output = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null ) {
            output.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return output;
    }

    private static void insert(TreeNode root, int value) {
        if (value < root.val) { // 放在左边
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new TreeNode(value);
            }
        } else if (value > root.val) {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new TreeNode(value);
            }
        }
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
