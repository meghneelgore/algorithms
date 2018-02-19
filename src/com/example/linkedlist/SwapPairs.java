package com.example.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


 * @author meghneel.gore
 *
 */

public class SwapPairs {

	public ListNode<Integer> swapPairs(ListNode<Integer> head) {
		if(head == null) return null;
		ListNode<Integer> p1 = head;
		if(p1.next == null) return p1;
		ListNode<Integer> p2 = head.next;
		ListNode<Integer> p3 = null;

		while(p2 != null) {
			p1.next = p2.next;
			p2.next = p1;
			if(p3 == null) {
				head = p2;	
			} else {
				p3.next = p2;
			}
			p3 = p1;
			p1 = p1.next;
			if(p1 == null) return head;
			p2 = p1.next;

		}
		return head;
	}


	public static void main(String[] args) {
		ListNode<Integer> n = new ListNode<>(1);
		n.next = new ListNode<>(2);
		n.next.next = new ListNode<>(3);
		n.next.next.next = new ListNode<>(4);
		n.next.next.next.next = new ListNode<>(5);
		n.next.next.next.next.next = new ListNode<>(6);

		SwapPairs s = new SwapPairs();
		n = s.swapPairs(n);

		while(n != null) {
			System.out.print(n.getData() + " -> ");
			n = n.next;
		}
		
	}
}
