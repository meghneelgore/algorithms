package com.example.tree.traversal;

public class VerifySerialzedBTree {
	public boolean isValidSerialization(String preorder) {
	    String[] nodes = preorder.split(",");
	    int diff = 1;
	    for (String node: nodes) {
	    	System.out.println("diff = " + diff);
	        if (--diff < 0) return false;
	        if (!node.equals("#")) diff += 2;
	    }
	    System.out.println("diff = " + diff);
	    return diff == 0;
	}
	
	public static void main(String[] args) {
		String a = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(new VerifySerialzedBTree().isValidSerialization("9,#,1,1,#,#,#"));
	}
}
