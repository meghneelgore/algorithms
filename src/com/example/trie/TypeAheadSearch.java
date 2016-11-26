package com.example.trie;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Class TypeAheadSearch. Takes a Trie object and can perform type ahead search on it.
 * 
 * @author meghneel.gore
 */
public class TypeAheadSearch {

	private final Trie trie;
	
	public TypeAheadSearch(Trie trie) {
		this.trie = trie;
	}
	
	public List<String> typeAheadSearch(String query) {
		LinkedList<String> list = new LinkedList<>();
		TrieNode current = trie.getHead();
		for(Character c: query.toCharArray()) {
			if(current.next.get(c) != null) {
				current = current.next.get(c);
			} else {
				return ImmutableList.of(); //Empty list
			}
		}
		searchAhead(trie.getHead().next.get(query.charAt(0)), "", list);
		return ImmutableList.copyOf(list);
	}

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