package com.example.trie;

import java.util.LinkedList;
import java.util.Set;
import com.google.common.collect.ImmutableSet;

/**
 * Class TypeAheadSearch. Takes a Trie object and can perform type ahead search on it.
 * 
 * @author meghneel.gore
 */
public class TypeAheadSearch {

	private final Trie trie;
	
	/**
	 * Constructor. Takes a Trie object on which it can perform type ahead search.
	 * @param trie The Trie object on which to perform the search.
	 */
	public TypeAheadSearch(Trie trie) {
		this.trie = trie;
	}
	
	/**
	 * Performs type ahead search on a Trie object. 
	 * 
	 * @param query Query string
	 * 
	 * @return Set of all the strings in the Trie that match the query string. Returns an empty
	 * set if nothing matches
	 */
	public Set<String> typeAheadSearch(String query) {
		LinkedList<String> list = new LinkedList<>();
		TrieNode current = trie.getHead();
		for(Character c: query.toCharArray()) {
			if(current.next.get(c) != null) {
				current = current.next.get(c);
			} else {
				return ImmutableSet.of(); //Empty set
			}
		}
		searchAhead(trie.getHead().next.get(query.charAt(0)), "", list);
		return ImmutableSet.copyOf(list);
	}

	/**
	 * Helper method to search through the Trie. This method is recursive.
	 * 
	 * @param current Current TrieNode
	 * @param currentString Current string that has been accumulated
	 * @param list List of all the words found until now.
	 */
	private void searchAhead(TrieNode current, String currentString, LinkedList<String> list) {
		if(current.index) {
			list.add(currentString + current.c);
		}
		if(current.next == null) return;
		
		for(TrieNode node: current.next.values()) {
			if(current == trie.getHead()) {
				searchAhead(node, currentString, list);
			} else {
				searchAhead(node, currentString + current.c, list);
			}
		}
	}
}