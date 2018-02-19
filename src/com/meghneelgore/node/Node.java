package com.meghneelgore.node;

public abstract class Node<T> {
	private final T data;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
