package com.example.serialization;

import com.meghneelgore.tree.TreeNode;

public class TreeSerializationTester {

	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<>("root"); //                                           root
		root.left = new TreeNode<>("left");     //                                     left          right
		root.right = new TreeNode<>("right"); //                                  left      null   null   right
		root.left.left = new TreeNode<>("left.left"); //                     null     right            null   null
		root.left.left.right = new TreeNode<>("left.left.right"); //                null    null 
		root.right.right = new TreeNode<>("right.right");  //                    
														//                 
		TreeSerialization serializer = new TreeSerialization();
		StringBuffer buffer = new StringBuffer();
		serializer.serialize(root, buffer);
		System.out.println(buffer.toString());
		
		TreeNode<String> deserializedRoot = serializer.deserialize(buffer.toString());
		buffer = new StringBuffer();
		serializer.serialize(deserializedRoot, buffer);
		System.out.println(buffer.toString());
		
	}
}
