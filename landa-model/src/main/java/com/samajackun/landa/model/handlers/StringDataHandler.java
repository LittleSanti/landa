package com.samajackun.landa.model.handlers;

public class StringDataHandler implements DataHandler<String, String>
{
	@Override
	public String parse(String s)
	{
		return s;
	}

	@Override
	public String serialize(String t)
	{
		return t;
	}

	@Override
	public int compare(String o1, String o2)
	{
		return o1.compareTo(o2);
	}
}
