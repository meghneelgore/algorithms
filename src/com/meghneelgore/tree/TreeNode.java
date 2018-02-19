package com.meghneelgore.tree;

import com.meghneelgore.node.Node;

public class TreeNode<T> extends Node<T>{
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T data) {
		super(data);
	}

	public static boolean leaf(TreeNode<?> n) {
		return (n.left == null) && (n.right == null);
	}
}
