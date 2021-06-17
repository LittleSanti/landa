package com.samajackun.landa.engine.dummy;

import java.util.HashSet;
import java.util.Set;

import com.samajackun.landa.engine.TransactionException;

public class DummyTable
{
	private final Set<Long> removedRows=new HashSet<>();

	public void removeRow(long rowId)
		throws TransactionException
	{
		this.removedRows.add(rowId);
	}

	public void setRow(long rowId, Object[] values)
		throws TransactionException
	{
		this.removedRows.add(rowId);
	}
}
