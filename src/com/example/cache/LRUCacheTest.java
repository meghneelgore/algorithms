package com.example.cache;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

	@Test 
	public void testInsertLessThanCapacity() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		cache.put(1, 1);
		cache.put(2, 2);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(2), cache.head.getData().value); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData().value); 
	}
	
	@Test
	public void testLRUChangesOnGet() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(3), cache.head.getData().value); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData().value); 
		
		cache.get(1);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(1), cache.head.getData().value); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(2), cache.tail.getData().value); 
	}
	
	@Test
	public void testLRUChangesOnGet2() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		
		Assert.assertEquals("Wrong element in head of linked list", new Integer(5), cache.head.getData().value); //5->4->3->2->1
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData().value); 
		
		cache.get(3);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(3), cache.head.getData().value); //3->5->4->2->1
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData().value); 
		
		cache.get(1);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(1), cache.head.getData().value); //1->3->5->4->2
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(2), cache.tail.getData().value); 
		
	}
	
	@Test
	public void testMapSize() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(4);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		
		Assert.assertEquals("Map size not correct", 4, cache.map.size());
		cache.put(5, 5);
		Assert.assertEquals("Map size not correct", 4, cache.map.size());
		
		
	}
	
	
	@Test
	public void testInsertMoreThanCapacity() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(2);
		cache.put(1, 1);
		cache.put(2, 2);
		Integer i = cache.put(3, 3);
		Assert.assertEquals("Expected element not removed from cache", new Integer(1), i);
	}

	@Test
	public void testMultiThreaded() {
		final LRUCache<Integer, Integer> cache = new LRUCache<>(20);
		
		new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					cache.put(i, i);
				}
			};
		}.start();
		Thread t = new Thread() {
			public void run() {
				for(int i = 10; i < 20; i++) {
					cache.put(i, i);
				}
			};
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 20; i++) {
			if(cache.get(i) == null) Assert.fail("Cache does not have expected value");
		}
		
		Assert.assertEquals("Unexpected cache size", 20, cache.map.size());
	}
}
