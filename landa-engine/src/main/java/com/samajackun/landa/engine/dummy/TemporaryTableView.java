package com.samajackun.landa.engine.dummy;

import java.util.HashSet;
import java.util.Set;

import com.samajackun.landa.engine.EngineException;
import com.samajackun.landa.engine.TableView;

public class TemporaryTableView extends ProxyTableView
{
	private final SourceTableView tmp=new SourceTableView();

	private final Set<Long> removed=new HashSet<>();

	public TemporaryTableView(TableView src)
	{
		super(src);
	}

	@Override
	public int size()
		throws EngineException
	{
		return this.tmp.size() + super.size() - this.removed.size();
	}

	@Override
	public Object[] get(long rowId)
		throws EngineException
	{
		if (this.removed.contains(rowId))
		{
			throw new RowNotFoundException(rowId);
		}
		try
		{
			return this.tmp.get(rowId);
		}
		catch (RowNotFoundException e)
		{
			return super.get(rowId);
		}
	}

	@Override
	public void set(long rowId, Object[] row)
		throws EngineException
	{
		if (this.removed.contains(rowId))
		{
			throw new RowNotFoundException(rowId);
		}
		else
		{
			try
			{
				this.tmp.set(rowId, row);
			}
			catch (RowNotFoundException e)
			{
				if (super.contains(rowId))
				{
					this.tmp.set(rowId, row);
				}
			}
		}
	}

	@Override
	public void delete(long rowId)
		throws EngineException
	{
		if (this.tmp.contains(rowId))
		{
			this.tmp.delete(rowId);
		}
		else if (super.contains(rowId))
		{
			this.removed.add(rowId);
		}
		else
		{
			throw new RowNotFoundException(rowId);
		}
	}

	@Override
	public long create(Object[] row)
		throws EngineException
	{
		return this.tmp.create(row);
	}
}
