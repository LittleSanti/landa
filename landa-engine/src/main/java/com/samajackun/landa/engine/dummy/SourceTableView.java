package com.samajackun.landa.engine.dummy;

import java.util.HashMap;
import java.util.Map;

import com.samajackun.landa.engine.EngineException;
import com.samajackun.landa.engine.TableView;

public class SourceTableView implements TableView
{
	private final Map<Long, Object[]> records=new HashMap<>();

	private long id=0;

	@Override
	public int size()
		throws EngineException
	{
		return this.records.size();
	}

	@Override
	public boolean contains(long rowId)
		throws EngineException
	{
		return this.records.containsKey(rowId);
	}

	@Override
	public Object[] get(long rowId)
		throws EngineException
	{
		return this.records.get(rowId);
	}

	private final Object[] getRecord(long rowId)
		throws RowNotFoundException
	{
		Object[] record=this.records.get(rowId);
		if (record == null)
		{
			throw new RowNotFoundException(rowId);
		}
		return record;
	}

	@Override
	public void set(long rowId, Object[] row)
		throws EngineException
	{
		Object[] record=getRecord(rowId);
		for (int i=0; i < record.length; i++)
		{
			record[i]=row[i];
		}
	}

	@Override
	public void delete(long rowId)
		throws EngineException
	{
		Object[] record=this.records.remove(rowId);
		if (record == null)
		{
			throw new RowNotFoundException(rowId);
		}
	}

	@Override
	public long create(Object[] row)
		throws EngineException
	{
		this.records.put(this.id, row);
		return this.id++;
	}
}
