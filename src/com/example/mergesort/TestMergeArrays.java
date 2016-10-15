package com.example.mergesort;

public class TestMergeArrays {
	static MergeArrays merge = new MergeArrays();
	
	public static void main(String[] args) {
		int[] a2 = {1};
		int[] a1 = {-10};
		
		int[] merged = merge.mergeArrays(a1, a2);
		
		for(int i = 0; i < merged.length; i++) {
			System.out.print(merged[i] + ",");
		}
	}
}
