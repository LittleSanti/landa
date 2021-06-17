package com.samajackun.landa.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Index<T extends Comparable<T>> implements Comparator<Integer>
{
	private final Map<T, Integer> map=new HashMap<>();

	private final Map<Integer, T> reverseMap=new HashMap<>();

	private int id=0;

	public Integer put(T s)
	{
		return this.map.computeIfAbsent(s, k -> {
			this.reverseMap.put(this.id, s);
			return this.id++;
		});
	}

	public T get(int key)
	{
		return this.reverseMap.get(key);
	}

	@Override
	public int compare(Integer o1, Integer o2)
	{
		return this.reverseMap.get(o1).compareTo(this.reverseMap.get(o2));
	}

	public int size()
	{
		return this.map.size();
	}

	Map<T, Integer> getMap()
	{
		return this.map;
	}

	Map<Integer, T> getReversemap()
	{
		return this.reverseMap;
	}

	int getId()
	{
		return this.id;
	}
}
