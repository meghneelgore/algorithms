package com.meghneelgore.tree.traversal;

import java.util.Comparator;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.meghneelgore.tree.TreeNode;

public class  TreeToColumns{

	
	public void printTreeInColumns(TreeNode<Integer> root) {
		Multimap<Integer, Integer> map = TreeMultimap.create(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		}, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		traverseTree(root, 0, map);
		printColumns(map);
	}

	private void printColumns(Multimap<Integer, Integer> map) {
		
		for(Integer key: map.keySet()) {
			System.out.print(map.get(key));
		}
		
	}

	private void traverseTree(TreeNode<Integer> root, int index, Multimap<Integer, Integer> map) {
		if(root == null ) return;
		
		traverseTree(root.left, index + 1, map);
		map.put(index, root.getData());
		traverseTree(root.right, index - 1, map);
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.right = new TreeNode<Integer>(7);
		
		TreeToColumns t = new TreeToColumns();
		t.printTreeInColumns(root);
	}
}
