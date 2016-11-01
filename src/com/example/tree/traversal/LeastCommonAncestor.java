package com.example.tree.traversal;

import com.example.tree.TreeNode;

public class LeastCommonAncestor {

	public TreeNode<?> findLCA(TreeNode<?> root, TreeNode<?> n1, TreeNode<?> n2) {
		if(root == null) return null;
		
		if(root == n1 || root == n2) return root;
		
		TreeNode<?> left = findLCA(root.left, n1, n2);
		TreeNode<?> right = findLCA(root.right, n1, n2);
		
		if(left != null && right != null) return root;
		
		if(left == null) return right;
		return left;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.left.right.left = new TreeNode<>(6);
		root.left.right.right = new TreeNode<>(7);
		
		LeastCommonAncestor lca = new LeastCommonAncestor();
		
		TreeNode<?> lcaNode = lca.findLCA(root, root.left.left, root.left);
		System.out.println(lcaNode.data);
	}
}
