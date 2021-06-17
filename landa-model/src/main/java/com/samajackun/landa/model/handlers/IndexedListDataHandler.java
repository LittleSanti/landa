package com.samajackun.landa.model.handlers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.samajackun.landa.util.ComparableList;
import com.samajackun.landa.util.Index;

public class IndexedListDataHandler implements DataHandler<Integer, String>
{
	private final Index<ComparableList<Integer>> index;

	private final Pattern pattern;

	private final IndexedStringDataHandler indexedStringDataHandler;

	public IndexedListDataHandler(Pattern pattern, Index<ComparableList<Integer>> index, IndexedStringDataHandler indexedStringDataHandler)
	{
		super();
		this.pattern=pattern;
		this.index=index;
		this.indexedStringDataHandler=indexedStringDataHandler;
	}

	@Override
	public Integer parse(String s)
	{
		Matcher matcher=this.pattern.matcher(s);
		ComparableList<Integer> set=new ComparableList<>(new ArrayList<Integer>());
		while (matcher.find())
		{
			String item=matcher.group(1);
			int n=this.indexedStringDataHandler.parse(item);
			set.add(n);
			item=matcher.group(2);
			if (item != null && !item.isEmpty())
			{
				n=this.indexedStringDataHandler.parse(item);
				set.add(n);
			}
		}
		return this.index.put(set);
	}

	@Override
	public String serialize(Integer t)
	{
		ComparableList<Integer> set=this.index.get(t);
		String s="";
		for (Integer n : set)
		{
			s+=this.indexedStringDataHandler.serialize(n);
		}
		return s;
	}

	@Override
	public int compare(Integer t1, Integer t2)
	{
		return this.index.compare(t1, t2);
	}
}
