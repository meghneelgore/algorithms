package com.example.tree.traversal;

import com.example.tree.TreeNode;

/**
 * Given a tree root and a number, find all full paths (from root to a leaf) that add up to the number.
 * 
 * For example
 *                                                  7
 *                                                4   8
 *                                              6  5 2  6
 *                                              
 *  n = 16, it should print 
 *  7 4 5
 *  
 *  n = 17 should print 
 *  7 4 6
 *  7 8 2                                      
 *                                            
 * @author meghneel.gore
 *
 */
public class TreePaths {
	public void findPathsWithSum(TreeNode<Integer> n, int remainingValue, String currentPath) {
		if(n == null) return;
		
		if(TreeNode.leaf(n) && (remainingValue - n.data) == 0) System.out.println(currentPath + n.data);
		
		findPathsWithSum(n.left, remainingValue - n.data, currentPath + n.data + " ");
		findPathsWithSum(n.right, remainingValue - n.data, currentPath + n.data + " ");
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(7);
		root.left = new TreeNode<>(4);
		root.right = new TreeNode<>(8);
		root.left.left = new TreeNode<>(6);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(2);
		root.right.right = new TreeNode<>(6);
		
		TreePaths p = new TreePaths();
		p.findPathsWithSum(root, 17, "");
	}

}
