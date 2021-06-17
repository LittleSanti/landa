package com.samajackun.landa.engine;

public interface TableView
{
	public int size()
		throws EngineException;

	public boolean contains(long rowId)
		throws EngineException;

	public Object[] get(long rowId)
		throws EngineException;

	public void set(long rowId, Object[] row)
		throws EngineException;

	public void delete(long rowId)
		throws EngineException;

	public long create(Object[] row)
		throws EngineException;
}
