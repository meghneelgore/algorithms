package com.example.trie;

import java.util.HashMap;
import java.util.List;

/**
 * Class Trie. Creates a trie from a given list of words.
 * 
 * @author meghneel.gore
 */
public class Trie {
	private final TrieNode head = new TrieNode(' ', false);
	
	/**
	 * Returns the head node of the trie.
	 * @return
	 */
	public TrieNode getHead() {
		return head;
	}

	/**
	 * Constructor. Creates a trie from the given list of dictionary words.
	 * 
	 * @param dictionary List of all the words in the dictionary.
	 */
	public Trie(final List<String> dictionary) {
		for(String s: dictionary) {
			TrieNode current = head;
			for(int i = 0; i < s.length(); i++) {
				if(current.next == null) {
					current.next = new HashMap<Character, TrieNode>();
				}
				char character = s.charAt(i);
				if(current.next.get(character) != null) {
					current = current.next.get(character);
				} else {
					current.next.put(character, new TrieNode(character, i == s.length() - 1));
					current = current.next.get(character);
				}	
			}
		}
	}
}
