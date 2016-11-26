package com.example.scratchpad;

import java.util.ArrayList;
import java.util.List;

public class Scratchpad {

	public static void permutation(String str) { 
	    permutation("", str); 
	} 
	 
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 1) System.out.println(prefix);
	    else { 
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    } 
	} 
	
	public static void listPerm(List<Integer> list) {
		List<Integer> prefix = new ArrayList<>();
		listPerm(prefix, list);
	}
	
	private static void listPerm(List<Integer> prefix, List<Integer> list) {
		int n = list.size();
		if(n == 0) printList(prefix);
		else {
			for(int i = 0; i < n; i++) {
				prefix.add(list.remove(0));
				listPerm(prefix, list);
			}
		}
	}
	
	private static void printList(List<Integer> prefix) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
//		for(int i = 1; i <= 100; i++) {
//			if(i % 15 == 0) {
//				System.out.println("FizzBuzz");
//			} else {
//				if(i % 3 == 0) {
//					System.out.println("Fizz");
//				} else if(i % 5 == 0) {
//					System.out.println("Buzz");
//				} else {
//					System.out.println(i);
//				}
//			}
//		}
		//permutation("aabb");
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		listPerm(a);
	}
}
