package com.example.trie;

import java.util.Arrays;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


import com.google.common.collect.ImmutableSet;

public class TrieTest {

	@Test
	public void testTypeAheadSearch() {
		Trie trie = new Trie(Arrays.asList(new String[]{"arkansas", "alabama", "california", "new hampshire", "new york"}));
		TypeAheadSearch search = new TypeAheadSearch(trie);
		
		Set<String> typeAhead = search.typeAheadSearch("new");
		Set<String> expectedList = ImmutableSet.of("new hampshire", "new york");
		Assert.assertEquals("Type ahead search gave wrong result", expectedList, typeAhead);
	}

}
