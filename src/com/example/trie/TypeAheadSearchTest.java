package com.example.trie;

import java.util.Arrays;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


import com.google.common.collect.ImmutableSet;

public class TypeAheadSearchTest {

	@Test
	public void testTypeAheadSearch() {
		Trie trie = new Trie(Arrays.asList(new String[]{"arkansas", "alabama", "california", "new hampshire", "new york", "washington", "new mexico"}));
		TypeAheadSearch search = new TypeAheadSearch(trie);
		Set<String> typeAhead = search.typeAheadSearch("new");
		Set<String> expectedList = ImmutableSet.of(" hampshire", " york", " mexico");
		Assert.assertEquals("Type ahead search gave wrong result", expectedList, typeAhead);
	}

	@Test
	public void testTypeAheadSearch2() {
		Trie trie = new Trie(Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa"}));
		TypeAheadSearch search = new TypeAheadSearch(trie);
		Set<String> typeAhead = search.typeAheadSearch("aa");
		Set<String> expectedSet = ImmutableSet.of("a", "aa");
		Assert.assertEquals("Type ahead search is wrong", expectedSet, typeAhead);
	}
}
