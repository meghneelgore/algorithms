package com.example.tree;

public class TreeNode<T> {

	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T data) {
		this.data = data;
	}
	
	public static boolean leaf(TreeNode<?> n) {
		return (n.left == null) && (n.right == null);
	}
}
