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
public class LowestCommonAncestor {

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
        TreeNode node = lowestCommonAncestor(root, node1, node2);
        System.out.println(node);
    }

    /**
     * 递归解析
     * 1、终止条件：
     * 当越过叶节点，则直接返回 null ；
     * 当 root 等于 p,q ，则直接返回 root ；
     *
     * 2、递推工作：
     * 开启递归左子节点，返回值记为 left ；
     * 开启递归右子节点，返回值记为 right ；
     *
     * 3、返回值： 根据 left 和 right ，可展开为四种情况；
     *    1.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     *    2.当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     *    3.当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *    p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *    p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     *
     *
     *
     *  【思路】
     * 因为lowestCommonAncestor(root, p, q)的功能是找出以root为根节点的两个节点p和q的最近公共祖先，所以递归体分三种情况讨论：
     *
     * 如果p和q分别是root的左右节点，那么root就是我们要找的最近公共祖先
     * 如果p和q都是root的左节点，那么返回lowestCommonAncestor(root.left,p,q)
     * 如果p和q都是root的右节点，那么返回lowestCommonAncestor(root.right,p,q)
     * 边界条件讨论：
     *
     * 如果root是null，则说明我们已经找到最底了，返回null表示没找到
     * 如果root与p相等或者与q相等，则返回root
     * 如果左子树没找到，递归函数返回null，证明p和q同在root的右侧，那么最终的公共祖先就是右子树找到的结点
     * 如果右子树没找到，递归函数返回null，证明p和q同在root的左侧，那么最终的公共祖先就是左子树找到的结点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
