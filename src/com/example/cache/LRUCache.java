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
	final HashMap<K, DoublyLinkedListNode<V>> map;
	DoublyLinkedListNode<V> head;
	DoublyLinkedListNode<V> tail;

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
	public V put(K key, V value) {
		if(map.size() == capacity) {
			//remove the tail form the linked list and return the value of the tail.
			DoublyLinkedListNode<V> t = tail;
			insertValueAsHead(key, value);		
			return t.getData();
		} else {
			insertValueAsHead(key, value);
			return null;
		}
	}

	private void insertValueAsHead(K key, V value) {
		DoublyLinkedListNode<V> v = new DoublyLinkedListNode<V>(value);

		if(map.size() == capacity) {
			tail = tail.getPrev();
			map.remove(key);
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
	public V get(K key) {
		//return null if doesn't exist
		if(map.get(key) == null) return null;
		
		

		//Bring the node to the head
		DoublyLinkedListNode<V> v = map.get(key);
		
		if(v == head) {
			return v.getData();
		}
		
		if(v == tail) {
			tail = tail.getPrev();
			head = v;
			return v.getData();
		}
		
		DoublyLinkedListNode<V> prev = v.getPrev();
		DoublyLinkedListNode<V> next = v.getNext();

		prev.setNext(next);
		next.setPrev(prev);

		v.setNext(head);
		head.setPrev(v);
		v.setPrev(tail);
		tail.setNext(v);
		
		head = v;

		//Return value;
		return v.getData();
	}

}
