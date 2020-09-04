package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day23.inverTree;

import java.util.*;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class InvertTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        insert(root, 2);
        insert(root, 1);
        insert(root, 7);
        insert(root, 3);
        insert(root, 6);
        insert(root, 9);
//       TreeNode node =  invertTree(root);
//        System.out.println(node);
//        TreeNode node = invertTreeTwo(root);
//        System.out.println(node);
        List<Integer> list;
//        list =  preOrderTraversal(root);
//        list = inOrderTraversal(root);
        list = postOrderTraversal(root);
        System.out.println(list);
    }

    /**
     * 迭代遍历， 利用前序遍历 根左右
     *
     * @param root
     * @return
     */
    private static TreeNode invertTreeTwo(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return root;
    }

    /**
     * 前序遍历， 根左右
     *
     * @param root
     * @return
     */
    private static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.addFirst(node.right);
            }
            if (node.left != null) {
                stack.addFirst(node.left);
            }

        }
        return list;
    }

    /**
     * 后序遍历， 左右根
     *
     * @param root
     * @return
     */
    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("node :" + node.val);
            list.addFirst(node.val);
            if (node.left != null) {
                stack.addFirst(node.left);
            }
            if (node.right != null) {
                stack.addFirst(node.right);
            }

        }
        return list;
    }

    /**
     * 中序遍历, 左根右
     *
     * @param root
     * @return
     */
    private static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }


    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    private static TreeNode invertTree(TreeNode root) {
        // termination
        if (root == null) {
            return null;
        }
        // process
        TreeNode node = root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // drill down
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        // reverse state
        return node;
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
