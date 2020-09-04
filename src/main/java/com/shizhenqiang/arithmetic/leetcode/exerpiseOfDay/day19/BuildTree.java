package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day19;


import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTree {

    static Map<Integer, Integer> map = new HashMap<>();

    static int[] post;

    public static void main(String[] args) {

        TreeNode node = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }

    private static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length) {
            return null;
        }
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        post= postOrder;
        return build(0, inOrder.length-1, 0, postOrder.length-1);
    }

    private static TreeNode build(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) {
            return null;
        }
        // 每次根据后序遍历最后一个索引从post中取出具体的值
        int root = post[pe];
        // 从中序遍历中取位置
        int ri = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = build(is, ri -1, ps,ps + ri -is -1);
        node.right = build(ri + 1, ie, ps+ri -is, pe-1);
        return node;
    }
}
