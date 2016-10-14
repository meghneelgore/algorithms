package com.example.quicksort;

import java.util.Random;

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
//		for(int i = 1; i < NUMBER_OF_ELEMENTS; i++) {
//			if(array[i - 1] > array[i]) {
//				System.out.println("Array not sorted at index " + i); 
//				return;
//			}
////			System.out.print(array[i] + " ");
//		}
//		System.out.println("Array sorted");
	}
	
	
}
