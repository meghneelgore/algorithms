package com.example.linkedlist;

public class ReverseLinkedList<T> {
	
	ListNode<T> head = null;

	public ReverseLinkedList(ListNode<T> head) {
		this.head = head;
	}
	
	public ListNode<T> reverseRecursive() {
		
		reverseRecursivePrivate(head);
		return head;
		
	}

	private void reverseRecursivePrivate(ListNode<T> curr) {
		if(curr == null) return;
		
		if(curr.next == null){
			head = curr;
			return;
		}
		
		reverseRecursivePrivate(curr.next);
		curr.next.next = curr;
		curr.next = null;
	}
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(3);
		System.out.println(head);
		ReverseLinkedList<Integer> ll = new ReverseLinkedList<Integer>(head);
		ListNode<Integer> h = ll.reverseRecursive();
		System.out.println(h);
	}
}
