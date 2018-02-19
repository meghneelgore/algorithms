package com.meghneelgore.counterarraylist;

import java.util.ArrayList;

/**
 * This class creates an array list that keeps track of how many add and remove operations were done on it.
 * 
 * @author "Meghneel Gore (meghneel.gore@gmail.com)"
 *
 */
public class CounterArrayList<T> {
	int opsCounter = 0;
	ArrayList<T> list = new ArrayList<>();
	

	public void add(T item) {
		opsCounter++;
		list.add(item);
	}
	
	public void remove(T item) {
		opsCounter++;
		list.remove(item);
	}
	
	public int size() {
		return list.size();
	}
	
	
}
