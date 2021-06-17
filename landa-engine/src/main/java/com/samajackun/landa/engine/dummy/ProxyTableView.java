package com.samajackun.landa.engine.dummy;

import com.samajackun.landa.engine.EngineException;
import com.samajackun.landa.engine.TableView;

public class ProxyTableView implements TableView
{
	private final TableView src;

	public ProxyTableView(TableView src)
	{
		super();
		this.src=src;
	}

	@Override
	public int size()
		throws EngineException
	{
		return this.src.size();
	}

	@Override
	public boolean contains(long rowId)
		throws EngineException
	{
		return this.src.contains(rowId);
	}

	@Override
	public Object[] get(long rowId)
		throws EngineException
	{
		return this.src.get(rowId);
	}

	@Override
	public void set(long rowId, Object[] row)
		throws EngineException
	{
		this.src.set(rowId, row);
	}

	@Override
	public void delete(long rowId)
		throws EngineException
	{
		this.src.delete(rowId);
	}

	@Override
	public long create(Object[] row)
		throws EngineException
	{
		return this.src.create(row);
	}

}
