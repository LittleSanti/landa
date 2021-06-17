package com.samajackun.landa.model.handlers;

import com.samajackun.landa.util.Index;

public class IndexedStringDataHandler implements DataHandler<Integer, String>
{
	private final Index<String> index;

	public IndexedStringDataHandler(Index<String> index)
	{
		super();
		this.index=index;
	}

	@Override
	public Integer parse(String s)
	{
		return this.index.put(s);
	}

	@Override
	public String serialize(Integer t)
	{
		return this.index.get(t);
	}

	@Override
	public int compare(Integer t1, Integer t2)
	{
		return this.index.compare(t1, t2);
	}
}
