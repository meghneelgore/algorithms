package com.example.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Testing {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<>();
		
		aList.add(10);
		//System.out.println("Size = " + aList.size());
		aList.add(0, 10);
		//System.out.println("Size = " + aList.size());
		
		Map<Integer, Integer> map = new TreeMap<>();
		Random random = new Random();
		
		int[] array = {100, -3, -10, -4, 1, 34, 5, 37};
		
		for(int i = 0; i < array.length; i++) {
			map.put(array[i], array[i]);
		}
		
		for(Integer i: map.keySet()) {
			System.out.println(i);
		}
		
		
	}
}
