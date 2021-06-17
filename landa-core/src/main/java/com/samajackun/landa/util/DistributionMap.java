package com.samajackun.landa.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class DistributionMap<K>
{
	private final Map<K, Integer> distribution=new HashMap<>();

	private final Comparator<Integer> descendingComparator=new Comparator<Integer>()
	{
		@Override
		public int compare(Integer o1, Integer o2)
		{
			int x=o1 < o2
				? 1
				: (o1 > o2
					? -1
					: 0);

			return x;
		}
	};

	private final SortedMap<Integer, Set<K>> frequenciesMap=new TreeMap<>(this.descendingComparator);

	public DistributionMap()
	{
		super();
	}

	public DistributionMap(DistributionMap<K> src)
	{
		super();
		this.distribution.putAll(src.distribution);
		for (Map.Entry<Integer, Set<K>> entry : src.frequenciesMap.entrySet())
		{
			this.frequenciesMap.put(entry.getKey(), new HashSet<>(entry.getValue()));
		}
	}

	public void add(K key)
	{
		synchronized (this)
		{
			int oldFrequency=this.distribution.computeIfAbsent(key, t -> 0);
			this.frequenciesMap.computeIfAbsent(oldFrequency, t -> new HashSet<>()).remove(key);
			int newFrequency=1 + oldFrequency;
			this.frequenciesMap.computeIfAbsent(newFrequency, t -> new HashSet<>()).add(key);
			this.distribution.put(key, newFrequency);
		}
	}

	public Double get(K key)
	{
		Integer num=this.distribution.get(key);
		return num == null
			? null
			: ((double)num) / this.distribution.size();
	}

	public Set<K> keySet()
	{
		return this.distribution.keySet();
	}

	public int size()
	{
		return this.distribution.size();
	}

	public boolean isEmpty()
	{
		return this.distribution.isEmpty();
	}

	public SortedMap<Integer, Set<K>> getFrequenciesMapInDescendingOrder()
	{
		return this.frequenciesMap;
	}

	public Set<K> getDataTypesInDescendingOrder()
	{
		LinkedHashSet<K> linkedSet=new LinkedHashSet<>();
		for (Set<K> set : this.frequenciesMap.values())
		{
			linkedSet.addAll(set);
		}
		return linkedSet;
	}

}
