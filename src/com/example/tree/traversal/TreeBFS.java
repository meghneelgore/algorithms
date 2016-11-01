package com.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.tree.TreeNode;

public class TreeBFS {



	public void  a(int... ints) {
		for(int a: ints) {
			System.out.println(a);
		}
	}

	private Queue<TreeNode<?>> queue;

	public TreeBFS() {
		queue = new LinkedList<TreeNode<?>>();
		a(1,33, 34, 35);
	}

	public void printTreeWithBFS(TreeNode<?> node) {
		if(node == null) {
			System.out.print("null ");
			return;
		}

		queue.add(node);

		double count = 1;

		int level = 0;
		while(queue.size() != 0) {
			TreeNode<?> n = queue.remove();
			if(n == null) {
				System.out.print("null ");
			} else {
				System.out.print(n.data + " ");
			}
			count--;
			if(count == 0) {
				System.out.println();
				level++;
				count = Math.pow(2, level);
			}

			if(n != null) {
				queue.add(n.left);
				queue.add(n.right);
			}
		}
	}

	public static void main(String[] args) {

		TreeBFS bfs = new TreeBFS();
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.right.right = new TreeNode<>(5);

		bfs.printTreeWithBFS(root);
		System.out.println();
		bfs.printTreeWithBFS(root.left);
	}

}
