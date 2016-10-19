package com.example.fibonacci;

import java.util.Hashtable;

public class Fibonacci {
	public int findNthFibonacci(int n) {
		n++;
		int[] h = new int[n];
		for(int i = 0; i < n; i++) {
			h[i] = -1;
		}
		return smartRecFib(--n, h);//(n);
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

	//Smart recursive
	private int smartRecFib(int n, int[] h) {
		if(n == 0 || n == 1) {
			h[n] = n;
		}
		
		if(h[n] != -1) return h[n];
		
		h[n] =  smartRecFib(n - 1, h) + smartRecFib(n - 2, h);
		
		return h[n];
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
