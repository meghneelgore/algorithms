package com.example.serialization;

import java.util.StringTokenizer;

public class TreeSerialization {
	
	StringBuffer buffer = new StringBuffer();

	public void serialize(TreeNode root, StringBuffer buffer) {
		if(root == null) { 
			buffer.append("null ");
			return;
		}
		
		buffer.append(root.data + " ");
		serialize(root.left, buffer);
		serialize(root.right, buffer);
		
		
	}
	
	public TreeNode deserialize(String serializedTree) {
		StringTokenizer tokenizer = new StringTokenizer(serializedTree, " ");
		
		TreeNode root = internalDeserialize(tokenizer, null);
		return root;
	}


	private TreeNode internalDeserialize(StringTokenizer tokenizer, TreeNode node) {
		TreeNode n = null;
		if(tokenizer.hasMoreElements()) {
			
			String nextEl = tokenizer.nextToken(); 
			if(nextEl.equals("null")) {
				return null;
			} else {
				n = new TreeNode(nextEl);
				n.left = internalDeserialize(tokenizer, n);
				n.right = internalDeserialize(tokenizer, n);
				
			}
		}

		return n;
	}
}
