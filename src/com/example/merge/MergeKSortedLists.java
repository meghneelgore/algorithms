package com.example.merge;

import com.example.linkedlist.ListNode;

public class MergeKSortedLists {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
	        if(lists == null || lists.length == 0) return null;
	        if(lists.length == 1) return lists[0];
	        
	        
	        
	        return sol(lists, 0, lists.length - 1);
	    }

	    
	    private ListNode<Integer> sol(ListNode<Integer>[] lists, int a, int b) {
	        int mid = (a + b) / 2;
	        System.out.println("a = " + a + " b = " + b + " mid = " + mid);
	        
	        if(a == b) return lists[0];
	        
	        //if(b - a == 1) return merge(lists[a], lists[b]);
	        
	        if(mid >= b) return null;
	        
	        
	        ListNode<Integer> l1 = sol(lists, a, mid);
	        ListNode<Integer> l2 = sol(lists, mid + 1, b);
	        return merge(l1, l2);
	    }
	    
	    private ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
	        if(list1 == null) return list2;
	        if(list2 == null) return list1;
	        
	        ListNode<Integer> l1 = list1;
	        ListNode<Integer> l2 = list2;
	        
	        ListNode<Integer> returnNode;
	        ListNode<Integer> currNode;
	        
	        if(l1.data < l2.data) {
	            returnNode = l1;
	            currNode = l1;
	            l1 = l1.next;
	        } else {
	            returnNode = l2;
	            currNode = l2;
	            l2 = l2.next;
	        }
	        
	        while(true) {
	            if(l1 == null) {
	                currNode.next = l2;
	                return returnNode;
	            }
	            if(l2 == null) {
	                currNode.next = l1;
	                return returnNode;
	            }
	            if(l1.data < l2.data) {
	                currNode.next = l1;
	                currNode = currNode.next;
	                l1 = l1.next;
	            } else {
	                currNode.next = l2;
	                currNode = currNode.next;
	                l2 = l2.next;
	            }
	        }
	    }
	}
}
