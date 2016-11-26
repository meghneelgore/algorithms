package com.example.trie;

import java.util.Map;

/**
 * Class TrieNode. Each node consists of one character, a boolean to signify if it's an index node 
 * (i.e. a word is formed at that node) and a map of all the subsequent letters in the trie formed 
 * by the currently given dictionary
 * 
 * @author meghneel.gore
 */
public class TrieNode {

	Character c;
	boolean index;
	Map<Character, TrieNode> next;
	
	public TrieNode(Character c, boolean index) {
		this.c = c;
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "[" + c + ", index = " + index + "]";
	}
}
