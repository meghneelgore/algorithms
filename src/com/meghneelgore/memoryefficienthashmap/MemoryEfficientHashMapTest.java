package com.meghneelgore.memoryefficienthashmap;

import static org.junit.Assert.*;


import org.junit.Test;


public class MemoryEfficientHashMapTest {

	@Test
	public void testResizeUp() {
		MemoryEfficientHashMap<Integer, Integer> map = new MemoryEfficientHashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		
		assertEquals("Size not as expected", 10, map.currentSize);
	}
	
	@Test
	public void testResizeDown() {
		MemoryEfficientHashMap<Integer, Integer> map = new MemoryEfficientHashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		assertEquals("Size not as expected", 10, map.currentSize);
		map.remove(4);
		map.remove(3);
		map.remove(2);
		assertEquals("Size not as expected", 5, map.currentSize);
	}
	
}
