package com.samajackun.landa.engine;

import java.util.ArrayList;
import java.util.List;

public class DummyTableView implements TableView
{
	private final List<Object[]> records=new ArrayList<>();

	@Override
	public int size()
		throws EngineException
	{
		return this.records.size();
	}

	@Override
	public Object[] get(long rowId)
		throws EngineException
	{
		return this.records.get((int)rowId);
	}

	@Override
	public void set(long rowId, Object[] row)
		throws EngineException
	{
		this.records.set((int)rowId, row);
	}

	@Override
	public void delete(long rowId)
		throws EngineException
	{
		this.records.remove((int)rowId);
	}

	@Override
	public long create(Object[] row)
		throws EngineException
	{
		this.records.add(row);
		return this.records.size() - 1;
	}

	@Override
	public boolean contains(long rowId)
		throws EngineException
	{
		// TODO Auto-generated method stub
		return false;
	}

}
