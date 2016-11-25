package com.example.linkedlist;

public class DoublyLinkedListNode<T> {
	private final T data;
	private DoublyLinkedListNode<T> next;
	private DoublyLinkedListNode<T> prev;
	
	public DoublyLinkedListNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public DoublyLinkedListNode<T> getPrev() {
		return prev;
	}
	
	public DoublyLinkedListNode<T> getNext() {
		return next;
	}
	
	public void setNext(DoublyLinkedListNode<T> next) {
		this.next = next;
	}
	
	public void setPrev(DoublyLinkedListNode<T> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
