package com.example.stack;

public class TestMaxStack {

	static MaxStack stack = new MaxStack();
	
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4); //max is 4 at this point
		System.out.println("Max is now: " + stack.getMax());
		stack.pop();
		stack.pop();
		stack.pop(); //max is 1
		stack.push(10);
		stack.push(9); //max is 10
		System.out.println("Max is now: " + stack.getMax());
		stack.pop(); //max is still 10
		System.out.println("Max is now: " + stack.getMax());
		stack.pop();
		System.out.println("Max is now: " + stack.getMax());
		
	}
}
