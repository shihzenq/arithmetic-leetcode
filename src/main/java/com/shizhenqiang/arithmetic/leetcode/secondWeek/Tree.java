package com.shizhenqiang.arithmetic.leetcode.secondWeek;

import java.util.Deque;
import java.util.LinkedList;

public class Tree {
	public static void main(String[] args) {
		//测试代码
		Integer[] nums = {1, 2, 3, null, null, 4, 5};
		TreeNode root = Tree.constructTree(nums);
		System.out.println(root);
		TreeNode treeNode = Tree.constructTree("[1,2,3,null,null,4,5]");
		System.out.println(treeNode);
	}

	//根据字符串生成树
	public static TreeNode constructTree(String str) {
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] split = str.split(",");
		Integer[] integers = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals("null")) {
				integers[i] = null;
			} else {
				integers[i] = Integer.parseInt(split[i]);
			}
		}
		return constructTree(integers);
	}

	//根据Integer数组生成树
	public static TreeNode constructTree(Integer[] nums) {
		if (nums.length == 0) return new TreeNode(0);
		Deque<TreeNode> nodeQueue = new LinkedList<>();
		// 创建一个根节点
		TreeNode root = new TreeNode(nums[0]);
		nodeQueue.offer(root);
		TreeNode cur;
		// 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
		int lineNodeNum = 2;
		// 记录当前行中数字在数组中的开始位置
		int startIndex = 1;
		// 记录数组中剩余的元素的数量
		int restLength = nums.length - 1;

		while (restLength > 0) {
			// 只有最后一行可以不满，其余行必须是满的
//            // 若输入的数组的数量是错误的，直接跳出程序
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new TreeNode(0);
//            }
			for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
				// 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i == nums.length) return root;
				cur = nodeQueue.poll();
				if (nums[i] != null) {
					cur.left = new TreeNode(nums[i]);
					nodeQueue.offer(cur.left);
				}
				// 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
				if (i + 1 == nums.length) return root;
				if (nums[i + 1] != null) {
					cur.right = new TreeNode(nums[i + 1]);
					nodeQueue.offer(cur.right);
				}
			}
			startIndex += lineNodeNum;
			restLength -= lineNodeNum;
			lineNodeNum = nodeQueue.size() * 2;
		}
		return root;
	}
}
