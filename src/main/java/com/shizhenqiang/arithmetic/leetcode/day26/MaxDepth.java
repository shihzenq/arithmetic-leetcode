package com.shizhenqiang.arithmetic.leetcode.day26;

import java.util.*;

/**
 * 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepth {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        root.children = Arrays.asList(node1, node2, node3);
        node1.children = Arrays.asList(node4, node5);
//        int a = maxDepth(root);
        int a = maxDepthTwo(root);
        System.out.println(a);
    }

    private static int maxDepthTwo(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        List<Node> children = root.children;
        if (null != children) {
            for (int i = 0; i < children.size(); i++) {
                int child = maxDepthTwo(children.get(i));
                max = Math.max(max, child);
            }
        }

        return max + 1;
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                if (current != null && current.children != null) {
                    for(Node child: current.children) queue.offer(child);
                }
            }

            depth++;
        }

        return depth;
    }
}
