package com.samajackun.landa.model.handlers;

import java.util.ArrayList;
import java.util.List;

public class Table<K>
{
	private final DataHandler<K, String> type;

	private final List<K> list=new ArrayList<>();

	public Table(DataHandler<K, String> type)
	{
		super();
		this.type=type;
	}

	public void add(String s)
	{
		this.list.add(this.type.parse(s));
	}

	public List<K> getList()
	{
		return this.list;
	}
}
