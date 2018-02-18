package com.meghneelgore.memoryefficienthashmap;

import java.util.HashMap;

/**
 * The regular HashMap class tends to increase size when required and when the load goes above
 * a certain threshold. However, it never reduces size if the load is too little. The memory efficient
 *  hash map tries to reduce the size of the map if the load is too little.
 *  
 * @author "Meghneel Gore (meghneel.gore@gmail.com)"
 *
 */
public class MemoryEfficientHashMap<K, V> {
	private static final int DEFAULT_MINIMUM_SIZE = 5; //Guaranteed to be random :)
	private static final float DEFAULT_RESIZE_UP_LOAD = 0.8f;
	private static final float DEFAULT_RESIZE_DOWN_LOAD = 0.2f;
	private final float resizeUpLoad;
	private final float resizeDownLoad;
	
	private int numItems = 0;
	int currentSize;
	final private int startSize;
	private HashMap<K, V> hashMap = new HashMap<>(DEFAULT_MINIMUM_SIZE);
	
	public MemoryEfficientHashMap() {
		this(DEFAULT_MINIMUM_SIZE, DEFAULT_RESIZE_UP_LOAD, DEFAULT_RESIZE_DOWN_LOAD);
	}
	public MemoryEfficientHashMap(int startSize, float resizeUpLoad, float resizeDownLoad) {
		if(startSize < 1) throw new IllegalArgumentException("Start size can't be zero or smaller");
		this.startSize = startSize;
		this.currentSize = startSize;
		if(resizeUpLoad <= 0) throw new IllegalArgumentException("Resize up load can't be 0 or smaller");
		if(resizeUpLoad < resizeDownLoad) throw new IllegalArgumentException("Resize up load value can't be less than the resize down load value");
		this.resizeUpLoad = resizeUpLoad;
		this.resizeDownLoad = resizeDownLoad;
	}
	public void put(K key, V value) {
		hashMap.put(key, value);
		numItems = hashMap.size();
		checkForResize();
	}

	public void remove(K key) {
		hashMap.remove(key);
		numItems = hashMap.size();
		checkForResize();
	}
	
	private void checkForResize() {
		if((float) numItems / (float) currentSize >= resizeUpLoad) {
			resizeUp();
		} else if((float) numItems / (float) currentSize <= resizeDownLoad ) {
			resizeDown();
		}
	}
	
	public int size() {
		return numItems;
	}
	
	private void resizeDown() {
		currentSize /= 2;
		if(currentSize < startSize) currentSize = startSize;
		final HashMap<K, V> temp = new HashMap<>(currentSize);
		temp.putAll(hashMap);
		hashMap = temp;
	}
	
	private void resizeUp() {
		// TODO Auto-generated method stub
		currentSize *= 2;
		final HashMap<K, V> temp = new HashMap<>(currentSize);
		temp.putAll(hashMap);
		hashMap = temp;
	}
	
	
}
