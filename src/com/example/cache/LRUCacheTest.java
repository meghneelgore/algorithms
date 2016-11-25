package com.example.cache;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

	@Test 
	public void testInsertLessThanCapacity() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		cache.put(1, 1);
		cache.put(2, 2);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(2), cache.head.getData()); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData()); 
	}
	
	@Test
	public void testLRUChangesOnGet() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(3), cache.head.getData()); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData()); 
		
		cache.get(1);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(1), cache.head.getData()); 
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(2), cache.tail.getData()); 
	}
	
	@Test
	public void testLRUChangesOnGet2() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(10);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		
		Assert.assertEquals("Wrong element in head of linked list", new Integer(5), cache.head.getData()); //5->4->3->2->1
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData()); 
		
		cache.get(3);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(3), cache.head.getData()); //3->5->4->2->1
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(1), cache.tail.getData()); 
		
		cache.get(1);
		Assert.assertEquals("Wrong element in head of linked list", new Integer(1), cache.head.getData()); //1->3->5->4->2
		Assert.assertEquals("Wrong element in tail of linked list", new Integer(2), cache.tail.getData()); 
		
	}
	
	
	@Test
	public void testInsertMoreThanCapacity() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(2);
		cache.put(1, 1);
		cache.put(2, 2);
		Integer i = cache.put(3, 3);
		Assert.assertEquals("Expected element not removed from cache", new Integer(1), i);
	}

}
