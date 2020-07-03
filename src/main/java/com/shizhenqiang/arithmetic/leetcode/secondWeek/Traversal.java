package com.shizhenqiang.arithmetic.leetcode.secondWeek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉树：
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 后序遍历：左右根
 * https://blog.csdn.net/soundwave_/article/details/53120766
 */
public class Traversal {
	//测试代码
	public static void main(String[] args) {
		TreeNode tree = Tree.constructTree("[1,2,6,10,11,4,20,32,18]");
		System.out.println("=== 前序遍历 ===");
		System.out.println("递归：");
		preOrderRecur(tree);
		System.out.println("\n迭代：");
		preOrderIteration(tree);
		System.out.println("\nMorris");
		preOrderMorris(tree);
		System.out.println("\n\n=== 中序遍历 ===");
		System.out.println("递归：");
		inOrderRecur(tree);
		System.out.println("\n迭代：");
		inOrderIteration(tree);
		System.out.println("\nMorris");
		inOrderMorris(tree);

		System.out.println("\n\n=== 后序遍历 ===");
		System.out.println("递归：");
		postOrderRecur(tree);
		System.out.println("\n迭代：");
		postOrderIteration(tree);
		System.out.println("\n迭代2：");
		postOrderIteration2(tree);
		System.out.println("\nMorris:");
		postOrderMorris(tree);
	}

	//递归前序遍历
	public static void preOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	//递归中序遍历
	public static void inOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.val + " ");
		inOrderRecur(head.right);
	}

	//递归后序遍历
	public static void postOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		postOrderRecur(head.left);
		postOrderRecur(head.right);
		System.out.print(head.val + " ");
	}

	//迭代前序遍历
	public static void preOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	//前序Morris
	public static void preOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur1 = head;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.val + " ");
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.val + " ");
			}
			cur1 = cur1.right;
		}
	}

	//中序迭代
	public static void inOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				cur = node.right;
			}
		}
	}

	//中序Morris遍历
	public static void inOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur1 = head;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			//构建连接线
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			System.out.print(cur1.val + " ");
			cur1 = cur1.right;
		}
	}

	//迭代后序遍历-两个栈
	public static void postOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(head);
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			if (node.left != null) {
				stack1.push(node.left);
			}
			if (node.right != null) {
				stack1.push(node.right);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().val + " ");
		}
	}

	//迭代后序遍历-一个栈
	public static void postOrderIteration2(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode peek = stack.peek();
			if (peek.left != null && peek.left != cur && peek.right != cur) {
				stack.push(peek.left);
			} else if (peek.right != null && peek.right != cur) {
				stack.push(peek.right);
			} else {
				System.out.print(stack.pop().val + " ");
				cur = peek;
			}
		}
	}

	//后序Morris
	public static void postOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur1 = head;//遍历树的指针变量
		TreeNode cur2 = null;//当前子树的最右节点
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
					postMorrisPrint(cur1.left);
				}
			}
			cur1 = cur1.right;
		}
		postMorrisPrint(head);
	}

	public static void postMorrisPrint(TreeNode head) {
		TreeNode reverseList = postMorrisReverseList(head);
		TreeNode cur = reverseList;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		postMorrisReverseList(reverseList);
	}

	public static TreeNode postMorrisReverseList(TreeNode head) {
		TreeNode cur = head;
		TreeNode pre = null;
		while (cur != null) {
			TreeNode next = cur.right;
			cur.right = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	//N叉树的前序遍历
	public List<Integer> preorder(NTreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> integers = new ArrayList<>();
		preorderN(root, integers);
		return integers;
	}

	public void preorderN(NTreeNode root, List<Integer> integers) {
		if (root == null) {
			return;
		}
		integers.add(root.val);
		for (int i = 0; i < root.children.size(); i++) {
			preorderN(root.children.get(i), integers);
		}
	}


	//	1104.二叉树寻路
//	public List<Integer> pathInZigZagTree(int label) {
//		ArrayList<Integer> integers = new ArrayList<>();
//		var a = (int) (Math.log(label) / Math.log(2));
//		while (label > 1) {
//			integers.add(label);
//			label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);
//		}
//		integers.add(1);
//		Collections.reverse(integers);
//		return integers;
//	}
}
