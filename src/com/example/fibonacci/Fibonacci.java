package com.example.fibonacci;

public class Fibonacci {
	public int findNthFibonacci(int n) {
		return recFib(n);
	}
	
	public int findNthFibonacciRecursive(int n) {
		return iterativeFib(n);
	}

	//Recursive Fibonacci
	private int recFib(int n) {
		
		if(n == 0) return 0; //We assume the sequence is 0, 1, 1, 2, 3, 5...

		if(n == 1) return 1;

		return recFib(n - 1) + recFib(n - 2);
	}


	private int iterativeFib(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int a = 0;
		int b = 1;
		int fib = 0;
		
		for(int i = 2; i <= n; i++ ) {
			fib = a + b;
			a = b;
			b = fib;
		}
		
		return fib;
	}
}
