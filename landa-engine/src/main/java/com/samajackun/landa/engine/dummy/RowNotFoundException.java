package com.samajackun.landa.engine.dummy;

import com.samajackun.landa.engine.EngineException;

public class RowNotFoundException extends EngineException
{
	private static final long serialVersionUID=2312532990093411129L;

	private final long rowId;

	public RowNotFoundException(long rowId)
	{
		super("Row not found with rowId=" + rowId);
		this.rowId=rowId;
	}

	public long getRowId()
	{
		return this.rowId;
	}
}
