package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day25;

/**
 * 面试题68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class LowestCommonAncestorThree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root.left = node1;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        root.right = node2;
        node2.left = node5;
        node2.right = node6;
        TreeNode node = lowestCommonAncestor(root, node6, node7);
        System.out.println(node.val);
    }

    /**
     * 1、递归出口
     * 如果root为空则说明已经到底了，则返回root
     * 如果root等于p或q，则说明已找到，返回root
     * 2、遍历root左子树
     *    如果左子树为空，则说明pq是在root的右子树，pq的最近公共祖先是在右子树
     * 3、同理，遍历root右子树
     *    如果右子树为空，则说明pq是在root的左子树，pq的最近公共祖先是在左子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


}
