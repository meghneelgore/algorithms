package com.example.tree.traversal;

import com.example.tree.TreeNode;

/**
 * Checks if a given tree is a BST
 * @author meghneel.gore
 *
 */
public class BSTChecker {

	public boolean checkForBST(TreeNode<Integer> node, int maxAllowed, int minAllowed) {
		if(node == null) return true;
		if(node.data > maxAllowed || node.data < minAllowed) return false;
		
		if(!checkForBST(node.left, node.data, minAllowed)) return false;
		if(!checkForBST(node.right, maxAllowed, node.data)) return false;;
		return true;
		
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(10);//                        10
		root.left = new TreeNode<>(5);//                                  5        18    
		root.right = new TreeNode<>(18);//                            3      6  (9)   20         The wrong element is in parentheses
		root.left.left = new TreeNode<>(3);//                          
		root.left.right = new TreeNode<>(6);
		root.right.left = new TreeNode<>(9);
		root.right.right = new TreeNode<>(20);
		
		
		TreeNode<Integer> root2 = new TreeNode<>(10);//                       10
		root2.left = new TreeNode<>(5);//                                5         18
		root2.right = new TreeNode<>(18);//                         3       6   15    20      This is a BST
		root2.left.left = new TreeNode<>(3);
		root2.left.right = new TreeNode<>(6);
		root2.right.left = new TreeNode<>(15);
		root2.right.right = new TreeNode<>(20);
		root2.right.right.right = new TreeNode<>(25);
		
		BSTChecker c = new BSTChecker();
		boolean isBST = c.checkForBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		if(isBST) {
			System.out.println("Tree is a BST");		
		} else {
			System.out.println("Tree is not a BST");
		}
		
		isBST = c.checkForBST(root2, Integer.MAX_VALUE, Integer.MIN_VALUE);
		if(isBST) {
			System.out.println("Tree is a BST");	
		} else {
			System.out.println("Tree is not a BST");
		}
	}
}
