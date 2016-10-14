package com.example.quicksort;

import java.util.Random;

/**
 * QuickSort
 * 
 * @author meghneel.gore
 *
 */
public class QuickSort {

	Random r = new Random();
	int partitionIndex = 0;
	
	public void sort(int[] array, int left, int right) {
		//The following is the recursive way.
//		if(left < right) {
//			partitionIndex = partition(array, left, right);
//			sort(array, left, partitionIndex - 1);
//			sort(array, partitionIndex + 1, right);
//		}
		
		
		//The following is the iterative way
		
		// create auxiliary stack
        int stack[] = new int[right - left + 1];
 
        // initialize top of stack
        int top = -1;
 
        // push initial values in the stack
        stack[++top] = left;
        stack[++top] = right;
 
        // keep popping elements until stack is not empty
        while (top >= 0)
        {
            // pop h and l
            right = stack[top--];
            left = stack[top--];
 
            // set pivot element at it's proper position
            int p = partition(array, left, right);
 
            // If there are elements on left side of pivot,
            // then push left side to stack
            if ( p-1 > left )
            {
                stack[ ++top ] = left;
                stack[ ++top ] = p - 1;
            }
 
            // If there are elements on right side of pivot,
            // then push right side to stack
            if ( p+1 < right )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = right;
            }
       }
	}

	private int partition(int[] array, int left, int right) {
		
		int pivot = array[right];
		int i = left;
		for(int j = left; j < right; j++) {
			if(array[j] <= pivot) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, right);
		return i;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
