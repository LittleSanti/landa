package com.samajackun.landa.engine.dummy;

import com.samajackun.landa.engine.Engine;
import com.samajackun.landa.engine.Transaction;
import com.samajackun.landa.engine.TransactionException;
import com.samajackun.landa.model.Schema;
import com.samajackun.landa.model.TableNotFoundException;

public class DummyTransaction implements Transaction
{
	// private final Engine engine;

	// private final Map<String, Schema> schemas=new HashMap<>();

	public DummyTransaction(Engine engine)
	{
		// this.engine=engine;
	}

	@Override
	public Object[] getRow(String schemaName, String tableName, long rowId)
		throws TransactionException
	{
		try
		{
			return getSchema(schemaName).getTable(tableName).getRow(rowId).getColumns().toArray();
		}
		catch (TableNotFoundException e)
		{
			throw new TransactionException(e);
		}
	}

	private Schema getSchema(String schemaName)
	{
		throw new UnsupportedOperationException();
		// return this.schemas.computeIfAbsent(schemaName, k -> new DummySchema(k, this.engine.getSchema(schemaName)));
	}

	@Override
	public void setRow(String schema, String table, long rowId, Object[] values)
		throws TransactionException
	{
	}

	@Override
	public long createRow(String schema, String table)
		throws TransactionException
	{
		return 0;
	}

	@Override
	public void deleteRow(String schema, String table, long rowId)
		throws TransactionException
	{
	}
}
