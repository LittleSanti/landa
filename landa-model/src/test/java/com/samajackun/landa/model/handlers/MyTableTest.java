package com.samajackun.landa.model.handlers;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.samajackun.landa.util.Index;

public class MyTableTest
{
	@Test
	public void testIntegers()
	{
		DataHandler<Integer, String> type=new IntegerDataHandler();
		Table<Integer> list=new Table<>(type);
		list.add("11");
		list.add("21");
		list.add("20");
		list.add("10");
		list.add("1");
		SortedSet<Integer> set=new TreeSet<>(type);
		set.addAll(list.getList());
		System.out.println(set);
	}

	@Test
	public void testStrings()
	{
		DataHandler<String, String> type=new StringDataHandler();
		Table<String> list=new Table<>(type);
		list.add("marzo");
		list.add("febrero");
		list.add("abril");
		list.add("agosto");
		list.add("diciembre");
		SortedSet<String> set=new TreeSet<>(type);
		set.addAll(list.getList());
		System.out.println(set);
	}

	@Test
	public void testIndexedStrings()
	{
		DataHandler<Integer, String> type=new IndexedStringDataHandler(new Index<String>());
		Table<Integer> list=new Table<>(type);
		list.add("marzo");
		list.add("febrero");
		list.add("marzo");
		list.add("abril");
		list.add("agosto");
		list.add("marzo");
		list.add("diciembre");
		list.add("marzo");
		System.out.println("list.getList()=" + list.getList());
		SortedSet<Integer> set=new TreeSet<>(type);
		set.addAll(list.getList());
		set.forEach(t -> System.out.print(type.serialize(t) + ","));
		System.out.println();
	}
}
