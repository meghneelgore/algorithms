package com.example.tree.traversal;

import com.example.tree.TreeNode;

public class MinDepth {
	public int minDepth(TreeNode<?> root) {
		return findMinDepth(root, Integer.MIN_VALUE, 1);
	}

	private int findMinDepth(TreeNode<?> node, int maxDepth, int currDepth) {

		if(node == null) return currDepth  + 1;
		if(node.left == null && node.right == null) return maxDepth + 1;

		if(maxDepth < currDepth) maxDepth = currDepth;
		if(node.left != null || node.right != null) {
			return Math.min(findMinDepth(node.left, maxDepth, currDepth + 1), 
					findMinDepth(node.right, maxDepth, currDepth + 1));
		}
		return -1;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<Integer>(2);
		root.left.left = new TreeNode<Integer>(3);
		root.left.left.left = new TreeNode<>(7);
		root.right = new TreeNode<Integer>(4);
		root.right.right = new TreeNode<>(5);
		root.right.right.right = new TreeNode<>(6);
		MinDepth m = new MinDepth();
		System.out.print(m.minDepth(root));
	}
}
