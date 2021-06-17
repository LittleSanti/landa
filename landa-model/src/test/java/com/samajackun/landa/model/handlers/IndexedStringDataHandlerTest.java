package com.samajackun.landa.model.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.samajackun.landa.util.Index;

public class IndexedStringDataHandlerTest
{
	@Test
	public void parseEempty()
	{
		Index<String> index=new Index<>();
		DataHandler<Integer, String> handler=new IndexedStringDataHandler(index);
		String s="";
		int key=handler.parse(s);
		assertEquals(s, handler.serialize(key));
	}

	@Test
	public void parseOneWord()
	{
		Index<String> index=new Index<>();
		DataHandler<Integer, String> handler=new IndexedStringDataHandler(index);
		String s="january";
		int key=handler.parse(s);
		assertEquals(s, handler.serialize(key));
	}

	@Test
	public void parseOneWordTwice()
	{
		Index<String> index=new Index<>();
		DataHandler<Integer, String> handler=new IndexedStringDataHandler(index);
		String s="january";
		int key1=handler.parse(s);
		int key2=handler.parse(s);
		assertEquals(key1, key2);
		assertEquals(s, handler.serialize(key1));
	}

	@Test
	public void parseTwoWords()
	{
		Index<String> index=new Index<>();
		DataHandler<Integer, String> handler=new IndexedStringDataHandler(index);
		String s1="january";
		int key1=handler.parse(s1);
		String s2="february";
		int key2=handler.parse(s2);
		assertNotEquals(key1, key2);
	}
}
