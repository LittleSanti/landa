package com.samajackun.landa.model.handlers;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;

import org.junit.Test;

import com.samajackun.landa.util.ComparableList;
import com.samajackun.landa.util.Index;

public class IndexedListDataHandlerTest
{
	@Test
	public void parseByBlanksEmpty()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ ]+)( +)");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="";
		int key1=dataHandler.parse(s);
		assertEquals(1, index.size());
		assertEquals(0, key1);
	}

	@Test
	public void parseByBlanksOneWord()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ ]+)( +)");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january";
		int key1=dataHandler.parse(s);
		assertEquals(1, index.size());
		assertEquals(0, key1);
	}

	@Test
	public void parseByBlanksTwoWords()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ ]+)( +)?");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january february";
		int key1=dataHandler.parse(s);
		assertEquals(3, index1.size());
		assertEquals(s, dataHandler.serialize(key1));
	}

	@Test
	public void parseByBlanksThreeWords()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ ]+)( +)?");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january february march";
		int key1=dataHandler.parse(s);
		assertEquals(4, index1.size());
		assertEquals(s, dataHandler.serialize(key1));
	}

	@Test
	public void parseByWhitespaceOneWord()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ \\t]+)([ \\t]*)");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january";
		int key1=dataHandler.parse(s);
		assertEquals(1, index1.size());
		assertEquals(s, dataHandler.serialize(key1));
	}

	@Test
	public void parseByWhitespaceTwoWords()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ \\t]+)([ \\t]*)");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january february";
		int key1=dataHandler.parse(s);
		assertEquals(3, index1.size());
		assertEquals(s, dataHandler.serialize(key1));
	}

	@Test
	public void parseByWhitespaceFourWords()
	{
		Index<ComparableList<Integer>> index=new Index<>();
		Pattern pattern=Pattern.compile("([^ \\t]+)([ \\t]*)");
		Index<String> index1=new Index<>();
		IndexedStringDataHandler indexedStringDataHandler=new IndexedStringDataHandler(index1);
		IndexedListDataHandler dataHandler=new IndexedListDataHandler(pattern, index, indexedStringDataHandler);
		String s="january february march   april\tmay";
		int key1=dataHandler.parse(s);
		assertEquals(8, index1.size());
		assertEquals(s, dataHandler.serialize(key1));
	}
}
