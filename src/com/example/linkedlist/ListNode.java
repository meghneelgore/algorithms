package com.example.linkedlist;

import com.meghneelgore.node.Node;

public class ListNode<T> extends Node<T>{

	public ListNode<T> next;
	
	public ListNode(T data) {
		super(data);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		ListNode<T> curr = this;
		
		while(curr != null) {
			buffer.append(curr.getData().toString());
			if(curr.next != null) buffer.append(" -> ");
			curr = curr.next;
		}
		return buffer.toString();
	}
}
