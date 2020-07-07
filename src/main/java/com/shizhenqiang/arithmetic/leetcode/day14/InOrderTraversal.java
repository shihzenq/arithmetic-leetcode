package com.shizhenqiang.arithmetic.leetcode.day14;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root,2);
        insert(root,3);
        insert(root,4);
        insert(root,7);
        insert(root,8);
        insert(root,6);
        List<Integer> list = inOrderTraversalOne(root);
        System.out.println(list);
        list = inOrderTraversalTwo(root);
        System.out.println(list);
    }

    private static List<Integer> inOrderTraversalTwo(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        return list;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static List<Integer> inOrderTraversalOne(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new LinkedList<>();
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

    private static void insert(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left != null) {
                insert(root.left, value);
            } else
            root.left = new TreeNode(value);
        } else if ( value > root.val) {
            if (root.right != null) {
                insert(root.right, value);
            } else root.right = new TreeNode(value);
        }
    }
}
