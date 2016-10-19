package com.example.fibonacci;

public class TestFibonacci {
	static Fibonacci fib = new Fibonacci();
	
	public static void main(String[] args) {
		System.out.println(fib.findNthFibonacci(5));
		
		System.out.println(fib.findNthFibonacciRecursive(5));
	}
	
}
