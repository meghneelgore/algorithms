package com.example.linkedlist;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	
	public ListNode(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		ListNode<T> curr = this;
		
		while(curr != null) {
			buffer.append(curr.data);
			if(curr.next != null) buffer.append(" -> ");
			curr = curr.next;
		}
		return buffer.toString();
	}
}
