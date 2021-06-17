package dev;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class MyTableTest
{
	@Test
	public void testIntegers()
	{
		Type<Integer> type=new IntegerType();
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
		Type<String> type=new StringType();
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
		Type<Integer> type=new IndexedStringType();
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
		System.out.println("IndexedStringType.getMap()=" + IndexedStringType.getMap());
		System.out.println("IndexedStringType.getReversemap()=" + IndexedStringType.getReversemap());
		System.out.println("IndexedStringType.getId()=" + IndexedStringType.getId());
	}
}
