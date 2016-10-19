package com.example.serialization;

import java.util.StringTokenizer;

import com.example.tree.TreeNode;

public class TreeSerialization {
	
	StringBuffer buffer = new StringBuffer();

	public void serialize(TreeNode<String> root, StringBuffer buffer) {
		if(root == null) { 
			buffer.append("null ");
			return;
		}
		
		buffer.append(root.data + " ");
		serialize(root.left, buffer);
		serialize(root.right, buffer);
		
		
	}
	
	public TreeNode<String> deserialize(String serializedTree) {
		StringTokenizer tokenizer = new StringTokenizer(serializedTree, " ");
		
		TreeNode<String> root = internalDeserialize(tokenizer);
		return root;
	}


	private TreeNode<String> internalDeserialize(StringTokenizer tokenizer) {
		TreeNode<String> n = null;
		if(tokenizer.hasMoreElements()) {
			
			String nextEl = tokenizer.nextToken(); 
			if(nextEl.equals("null")) {
				return null;
			} else {
				n = new TreeNode<String>(nextEl);
				n.left = internalDeserialize(tokenizer);
				n.right = internalDeserialize(tokenizer);
				
			}
		}
		return n;
	}
}
