package com.example.stack;

import java.util.Stack;

/**
 * Create a class called MaxStack from Stack that will help you to find the largest element currently in the stack
 */

public class MaxStack extends Stack<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5330647204066829795L;
	Stack<Integer> maxStack = new Stack<>();
	
	@Override
	public Integer push(Integer item) {
		if(maxStack.size() > 0) {
			if(maxStack.peek() < item) {
				maxStack.push(item);
			}
		} else {
			maxStack.push(item);
		}
		String a ="last";
		String b = "losting";
		
		if(a.compareTo(b) < 0) {
			System.out.println("Yes");
		}
		return super.push(item);
	}
	

	public synchronized int getMax() {
		return maxStack.peek();
	}
	
	@Override
	public synchronized Integer pop() {
		if(peek().equals(maxStack.peek())) {
			maxStack.pop();
		}
		return super.pop();
	}
}
