package com.example.mergesort;

public class MergeArrays {

	public int[] mergeArrays(int[] arr1, int[] arr2) {
		int size = arr1.length + arr2.length;
		int[] returnArray = new int[size];
		int pointer1 = 0, pointer2 = 0;
		int index = 0;
		if(arr1.length == 0) return arr2;
		if(arr2.length == 0) return arr1;
		while(index < size) {

			if(pointer1 >= arr1.length) {
				System.arraycopy(arr2, pointer2, returnArray, index, arr2.length - pointer2);
				return returnArray;
			}
			if(pointer2 >= arr2.length) {
				System.arraycopy(arr1, pointer1, returnArray, index, arr1.length - pointer1);
				return returnArray;		
			}
			//Index out of bounds is taken care of in the previous two ifs
			if(arr1[pointer1] < arr2[pointer2]) {
				returnArray[index++] = arr1[pointer1++];
			} else if(pointer2 < arr2.length) {
				returnArray[index++] = arr2[pointer2++];
			} 
		}
		return returnArray;
	}
}
