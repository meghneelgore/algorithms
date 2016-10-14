package com.example.quicksort;

import java.util.Random;

/**
 * Helper class to check various sorting algorithms
 * @author meghneel.gore
 *
 */
public class SortSort {
	private static final int NUMBER_OF_ELEMENTS = 10000000;

	static Random r = new Random();

	static int[] array = new int[NUMBER_OF_ELEMENTS];//{3, 4, 5, 1, 2, 7, 8, 9, 6, 10};
	
	public static void main(String[] args) {
		for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			array[i] = r.nextInt();
		}
		
		QuickSort qs = new QuickSort();
		long t1 = System.currentTimeMillis();
		qs.sort(array, 0, NUMBER_OF_ELEMENTS - 1);
		long t2 = System.currentTimeMillis();
		
		System.out.println("Sorting took " + (t2 - t1) + " ms");
	}
	
	
}
