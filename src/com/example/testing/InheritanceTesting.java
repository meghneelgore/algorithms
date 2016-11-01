package com.example.testing;

import java.util.TreeSet;

public class InheritanceTesting {

	private InheritanceTesting() {
		
	}
	
	
	public InheritanceTesting(int i) {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		InheritanceTesting i = new InheritanceTesting();
		B b = new B(10);
	}
}

class B extends InheritanceTesting {
 
	TreeSet<Integer> tree;
	public B(int n) {
		super(10);
	}
}
