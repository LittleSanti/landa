package dev;

import java.util.ArrayList;
import java.util.List;

public class Table<T>
{
	private final Type<T> type;

	private final List<T> list=new ArrayList<>();

	public Table(Type<T> type)
	{
		super();
		this.type=type;
	}

	public void add(String s)
	{
		this.list.add(this.type.parse(s));
	}

	public List<T> getList()
	{
		return this.list;
	}
}
