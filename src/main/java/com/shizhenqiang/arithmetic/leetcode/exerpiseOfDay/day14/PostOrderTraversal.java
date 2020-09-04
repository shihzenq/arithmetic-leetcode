package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day14;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root, 2);
        insert(root, 4);
        insert(root, 6);
        insert(root, 8);
        insert(root, 7);
        insert(root, 3);

        List<Integer> list = postOrderTraversal(root);
        System.out.println(list);
    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
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
