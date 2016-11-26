package com.example.trie;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class TrieTest {

	@Test
	public void testTypeAheadSearch() {
		Trie trie = new Trie(Arrays.asList(new String[]{"arkansas", "alabama", "california", "new hampshire", "new york"}));
		TypeAheadSearch search = new TypeAheadSearch(trie);
		
		List<String> typeAhead = search.typeAheadSearch("new");
		List<String> expectedList = ImmutableList.of("new york", "new hampshire");
		Assert.assertEquals("Type ahead search gave wrong result", expectedList, typeAhead);
	}

}
