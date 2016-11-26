package com.example.cache;

import java.util.HashMap;

import com.example.linkedlist.DoublyLinkedListNode;

/**
 * Class to maintain a least recently used cache of generic type keyed on type K and having items of value of type V.
 * 
 * @author meghneel.gore
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class LRUCache<K, V> {

	private final int capacity;
	final HashMap<K, DoublyLinkedListNode<Pair<K, V>>> map;
	
	DoublyLinkedListNode<Pair<K, V>> head;
	DoublyLinkedListNode<Pair<K, V>> tail;

	
	static class Pair<T1, T2> {
		public Pair(T1 key, T2 value) {
			this.key = key;
			this.value = value;
		}
		T1 key;
		T2 value;
		
		@Override
		public String toString() {
			return "[" + key + " -> " + value + "]";
		}
	}
	
	/**
	 * Initializes LRUCache with predetermined capacity. 
	 * @param capacity
	 */
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	/**
	 * Puts a particular value in the cache keyed to the specified key. If the cache is full, the least recently used item 
	 * is removed and returned.
	 * 
	 * @param key Key to be used to save the value.
	 * 
	 * @param value Value to be saved in the cache.
	 * 
	 * @return If an item is being removed, return that item; null otherwise.
	 * 
	 */
	public synchronized V put(K key, V value) {
		if(map.get(key) != null) {
			DoublyLinkedListNode<Pair<K, V>> node = map.get(key);
			node.setData(new LRUCache.Pair<>(key, value));
			return get(key);
		}
		if(map.size() == capacity) {
			//remove the tail form the linked list and return the value of the tail.
			DoublyLinkedListNode<Pair<K, V>> t = tail;
			insertValueAsHead(key, value);		
			return t.getData().value;
		} else {
			insertValueAsHead(key, value);
			return null;
		}
	}

	/**
	 * Inserts a new item into the cache while maintaining LRU and capacity restrictions
	 * @param key Key
	 * @param value Value
	 */
	private void insertValueAsHead(K key, V value) {
		DoublyLinkedListNode<Pair<K, V>> v = new DoublyLinkedListNode<Pair<K, V>>(new Pair<>(key, value));

		if(map.size() == capacity) {
			tail = tail.getPrev();
			map.remove(tail.getData().key);
		}
		
		v.setNext(head);
		v.setPrev(tail);
		if(head == null) head = v;
		if(tail == null) tail = v;

		head.setPrev(v);
		head = v;
		
		tail.setNext(v);
		map.put(key, v);
	}


	/**
	 * Gets a particular value element based on the key provided.
	 * 
	 * @param key The key that indexes all the values.
	 * 
	 * @return The value corresponding to the key. null is returned if value doesn't exist.
	 */
	public synchronized V get(K key) {
		//return null if doesn't exist
		if(map.get(key) == null) return null;

		//Bring the node to the head
		DoublyLinkedListNode<Pair<K, V>> v = map.get(key);
		
		if(v == head) {
			return v.getData().value;
		}
		
		if(v == tail) {
			tail = tail.getPrev();
			head = v;
			return v.getData().value;
		}
		
		DoublyLinkedListNode<Pair<K, V>> prev = v.getPrev();
		DoublyLinkedListNode<Pair<K, V>> next = v.getNext();

		prev.setNext(next);
		next.setPrev(prev);

		v.setNext(head);
		head.setPrev(v);
		v.setPrev(tail);
		tail.setNext(v);
		
		head = v;

		//Return value;
		return v.getData().value;
	}
}
